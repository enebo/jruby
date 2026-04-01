#!/usr/bin/env ruby
# Generates an outline of all productions in a bison .y file by stripping
# action code (the { ... } blocks) from each production rule.
#
# Usage: ruby outline_bison.rb <file.y>

abort "Usage: #{$0} <file.y>" if ARGV.empty?

source = File.read(ARGV[0])

# Extract only the section between the two %% markers
sections = source.split(/^%%\s*$/)
abort "Could not find two %% markers in file" if sections.length < 3

productions_text = sections[1]

# Strip action code: remove { ... } blocks, handling nested braces,
# strings, and line comments.
def strip_actions(text)
  result = +""
  i = 0
  while i < text.length
    ch = text[i]

    if ch == '{'
      # Skip over the entire { ... } action block, tracking nesting,
      # strings, char literals, and comments inside.
      depth = 1
      i += 1
      while i < text.length && depth > 0
        c = text[i]
        if c == '{'
          depth += 1
        elsif c == '}'
          depth -= 1
        elsif c == '/' && text[i + 1] == '*'
          # Block comment: skip until */
          i += 2
          i += 1 while i < text.length - 1 && !(text[i] == '*' && text[i + 1] == '/')
          i += 1 # skip the closing /
        elsif c == '/' && text[i + 1] == '/'
          # Line comment: skip to end of line
          i += 1 while i < text.length && text[i] != "\n"
          next
        elsif c == '"'
          # Double-quoted string
          i += 1
          while i < text.length
            sc = text[i]
            break if sc == '"'
            i += 1 if sc == '\\' && i + 1 < text.length  # skip escaped char
            i += 1
          end
        elsif c == "'"
          # Single-quoted char literal
          i += 1
          while i < text.length
            sc = text[i]
            break if sc == "'"
            i += 1 if sc == '\\' && i + 1 < text.length  # skip escaped char
            i += 1
          end
        end
        i += 1
      end
      # Don't emit anything for the action block
    else
      result << ch
      i += 1
    end
  end
  result
end

outline = strip_actions(productions_text)

# Clean up: collapse runs of blank lines to a single blank line
outline = outline.gsub(/\n{3,}/, "\n\n")

# Strip trailing whitespace, remove trailing semicolons, and collapse multiple spaces into one on each line
outline = outline.each_line.map { |line| line.rstrip.delete_suffix(';').rstrip.gsub(/ {2,}/, ' ') }.join("\n")

puts outline
