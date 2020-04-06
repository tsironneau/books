package chapter6;

public class Item_34_EnumInsteadOfIntConstants {

    private class IntConstants {
        public static final int ELEMENT_HYDROGEN = 0;
        public static final int ELEMENT_OXYGEN = 1;
        public static final int ELEMENT_MERCURY = 2;

        public static final int MYTHOLOGY_ZEUS = 0;
        public static final int MYTHOLOGY_ATHENA = 1;
        public static final int MYTHOLOGY_MERCURY = 2;
    }

    private class UseOfIntConstants {

        void examples() {
            /*1*/boolean noTypeSafety = IntConstants.ELEMENT_HYDROGEN == IntConstants.MYTHOLOGY_ZEUS;
            /*2*/boolean sharedNamespaceNeedPrefixInName = IntConstants.ELEMENT_MERCURY != IntConstants.MYTHOLOGY_MERCURY;

            /*3 What if we change the value of one of the constants ? It could break the behaviour in the client using our code */

            /*4 No easy way for toString */
            System.out.println(IntConstants.MYTHOLOGY_ATHENA);//Not very helpful
        }

    }

    private enum Mythology {ZEUS, ATHENA, MERCURY}
    private enum Elements{HYDROGEN, OXYGEN, MERCURY}

    private class UseOfEnumConstants {

        void examples(){
            /*1 final boolean doesNotCompile = Mythology.ZEUS == Elements.OXYGEN;*/
            /*2 No need to prefix the name, the name space is different */
            /*3 Reordering values won't break the client (if he does not rely on ordinal() method */

            System.out.println(Mythology.ATHENA);//prints ATHENA, more useful than a simple integer
        }

    }

}
