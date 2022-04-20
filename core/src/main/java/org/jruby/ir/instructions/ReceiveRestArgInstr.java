package org.jruby.ir.instructions;

import org.jruby.ir.IRVisitor;
import org.jruby.ir.Operation;
import org.jruby.ir.operands.Variable;
import org.jruby.ir.persistence.IRReaderDecoder;
import org.jruby.ir.persistence.IRWriterEncoder;
import org.jruby.ir.runtime.IRRuntimeHelpers;
import org.jruby.ir.transformations.inlining.CloneInfo;
import org.jruby.ir.transformations.inlining.InlineCloneInfo;
import org.jruby.ir.transformations.inlining.SimpleCloneInfo;
import org.jruby.parser.StaticScope;
import org.jruby.runtime.DynamicScope;
import org.jruby.runtime.ThreadContext;
import org.jruby.runtime.builtin.IRubyObject;

/*
 * Assign rest arg passed into method to a result variable
 */
public class ReceiveRestArgInstr extends ReceiveArgBase implements FixedArityInstr {
    /** Number of arguments already accounted for */
    public final int required;

    public ReceiveRestArgInstr(Variable result, int required, int argIndex, Variable keywords) {
        super(Operation.RECV_REST_ARG, result, keywords, argIndex);
        this.required = required;
    }

    @Override
    public String[] toStringNonOperandArgs() {
        return new String[] { "index: " + getArgIndex(), "req: " + required };
    }

    @Override
    public Instr clone(CloneInfo info) {
        if (info instanceof SimpleCloneInfo) return new ReceiveRestArgInstr(info.getRenamedVariable(result), required, argIndex, info.getRenamedVariable(getKeyword()));

        InlineCloneInfo ii = (InlineCloneInfo) info;

        // FIXME: Check this
        if (ii.canMapArgsStatically()) return new CopyInstr(ii.getRenamedVariable(result), ii.getArg(argIndex, true));

        return new RestArgMultipleAsgnInstr(ii.getRenamedVariable(result), ii.getArgs(), argIndex, (required - argIndex), argIndex);
    }

    @Override
    public void encode(IRWriterEncoder e) {
        super.encode(e);
        e.encode(required);
        e.encode(getArgIndex());
    }

    public static ReceiveRestArgInstr decode(IRReaderDecoder d) {
        return new ReceiveRestArgInstr(d.decodeVariable(), d.decodeInt(), d.decodeInt(), d.decodeVariable());
    }

    @Override
    public IRubyObject receiveArg(ThreadContext context, IRubyObject self, DynamicScope currDynScope, StaticScope currScope,
                                  Object[] temp, IRubyObject[] args, boolean acceptsKeywordArgument, boolean ruby2keyword) {
        Object keyword = getKeyword().retrieve(context, self, currScope, currDynScope, temp);

        return IRRuntimeHelpers.receiveRestArg(context, args, required, argIndex, acceptsKeywordArgument, keyword);
    }

    @Override
    public void visit(IRVisitor visitor) {
        visitor.ReceiveRestArgInstr(this);
    }
}
