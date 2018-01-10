# frozen_string_literal: false
require 'test/unit'
class TestAssertion < Test::Unit::TestCase
  def test_wrong_assertion
    error, line = assert_raise(ArgumentError) {assert(true, true)}, __LINE__
    assert_match(/assertion message must be String or Proc, but TrueClass was given/, error.message)
    assert_match(/\A#{Regexp.quote(__FILE__)}:#{line}:/, error.backtrace[0])
  end

  def test_timeout_separately
    assert_raise(Timeout::Error) do
      assert_separately([], <<~"end;", timeout: 0.1)
        sleep
      end;
    end
  end
end
