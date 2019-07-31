package chapter2;

import java.io.Serializable;

/*
Singleton is used when we want only one instance of the class in all the application
-> To ensure this state, we need a private constructor
-> Two possible approach : public field or public factory methods : prefer the public field over factory method because it
 is simpler unless you need a specificity of the factory method (i.e. a different instance for each Thread...)
-> A third approach is also possible : single value enum, it should be the preferred approach because it doesn't not allow
multiple instantiation or reflection and also handle properly serialisation
- We can still use reflective to change the visibility of the constructor
- Serialization : we need to implement the readResolve method to avoid to create another instance
 */
public final class Item_3_Singleton {

    private class SingletonPublicField implements Serializable {
        public final SingletonPublicField INSTANCE = new SingletonPublicField();

        private SingletonPublicField() {
        }

        public Object readResolve(){
            return INSTANCE;
        }
    }

    private class SingletonPublicFactoryMethod implements Serializable{
        private final SingletonPublicFactoryMethod INSTANCE = new SingletonPublicFactoryMethod();

        private SingletonPublicFactoryMethod() {
        }

        public final SingletonPublicFactoryMethod getInstance(){
            return INSTANCE;
        }

        public Object readResolve(){
            return INSTANCE;
        }
    }

    private enum SingletonEnum{
        INSTANCE;
    }
}
