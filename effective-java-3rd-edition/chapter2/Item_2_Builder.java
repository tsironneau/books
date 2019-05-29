package chapter2;

import java.util.Objects;

/*
Builder instead of constructors with a lot of parameters
+ Easier to read, easier to use
+ Help to avoid mistakes in parameters order
+ Creates an immutable object
+ Easy to use in class hierarchy
 */
public final class Item_2_Builder {

    public static void main(final String[] args) {
        final FightEffect.Builder builder = new FightEffect.Builder();
        final FightEffect effect = builder
                .id(1)
                .type(FightEffect.Type.HP_LOSS)
                .build();
        System.out.println(effect);
    }
}

abstract class Effect {

    private final int m_id;

    abstract static class Builder<T extends Builder<T>> {
        private int m_id;

        T id(final int id) {
            m_id = id;
            return self();
        }

        abstract Effect build();

        abstract T self();
    }

    Effect(final Builder<?> builder) {
        m_id = builder.m_id;
    }

    @Override
    public String toString() {
        return "Effect{" +
                "m_id=" + m_id +
                '}';
    }
}

class FightEffect extends Effect {

    enum Type {HP_LOSS, HP_GAIN}

    private final Type m_type;

    static class Builder extends Effect.Builder<Builder> {
        private Type m_type;

        Builder type(final Type type) {
            m_type = Objects.requireNonNull(type);
            return self();
        }

        @Override
        FightEffect build() {
            return new FightEffect(this);
        }

        @Override
        Builder self() {
            return this;
        }
    }

    private FightEffect(final Builder builder) {
        super(builder);
        m_type = builder.m_type;
    }

    @Override
    public String toString() {
        return "FightEffect{" +
                "m_type=" + m_type +
                "} " + super.toString();
    }
}
