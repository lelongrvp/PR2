package a3_1801040081;

import java.util.ArrayList;

import utils.DomainConstraint;
import utils.AttrRef;
import utils.DOpt;
import utils.OptType;
/**
 * @overview providing array for saving String[] comps and PC[]
 * @attribute
 * element  ArrayList<String>
 * @object A typical Set object is c = {a1,...,an} where a1,...,an are elements
 * @abstract_properties optional(elements) = false /\ for all a in elements: a is String
 */
public class Set {
    @DomainConstraint(type = "ArrayList", optional = false)
    private ArrayList<Object> elements;

    /**
     * @effects initialise this to be empty
     */
    public Set(){
        elements = new ArrayList<>();
    }

    /**
     * @modifies <tt>this</tt>
     * @effects <pre>
     *     if String x is already in this
     *          do nothing
     *     else
     *          add x to this, i.e this_post = this + {x}
     * </pre>
     */
    @DOpt(type = OptType.MutatorAdd)
    public void insert(Object x){
        if(elements.indexOf(x) < 0){
            elements.add(x);
        }
    }

    /**
     * @effects <tt>return the size of this</tt>
     */
    @DOpt(type = OptType.ObserverSize)
    public int size(){
        return elements.size();
    }

    /**
     * @effects <pre>
     *     if this is not empty
     *          return array String[] of elements of this
     *     else
     *          return null
     * </pre>
     */
    @DOpt(type = OptType.Observer)
    public Object[] getObjects(){
        if(size() == 0){
            return null;
        }
        else{
            Object[] arr = new Object[size()];
            for (int i = 0; i < elements.size(); i++){
                arr[i] = elements.get(i);
            }

            return arr;
        }
    }

    /**
     * @effects <pre>
     *     if this is not empty
     *          return this as String in Array form, i.e [str1,str2,etc]
     *     else
     *          return [];
     * </pre>
     */
    @DOpt(type = OptType.Observer)
    public String toArrayString(){
        if(size() == 0){
            return "[]";
        }
        else{
            String s = "[";
            for(int i = 0; i < elements.size(); i++){
                if(i == 0)
                    s += elements.get(i);
                else{
                    s += " ," + elements.get(i);
                }
            }

            return s + "]";
        }
    }

    /**
     * @effects <tt>return a clone of this</tt>
     */
    public Set clone(){
        Set s = new Set();
        for(int i = 0; i < elements.size(); i++){
            s.insert(elements.get(i));
        }

        return s;
    }

    @Override
    public String toString(){
        if (size() == 0)
            return "Set:{}";

        String s = "Set:{" + elements.get(0);
        for(int i = 1; i < size(); i++){
            s = s + " , " + elements.get(i);
        }

        return s + "}";
    }

    @Override
    public boolean equals(Object o){
        if (!(o instanceof Set))
            return false;

        return elements.equals(((Set) o).elements);
    }

    /**
     * @effects <pre>
     *     is this satisfies abstract properties
     *          return true
     *     else
     *          return false
     * </pre>
     */
    public boolean repOK() {
        if (elements == null){
            return false;
        }

        for (int i = 0; i < elements.size(); i++){
            Object x = elements.get(i);

            for (int j = i + 1; j < elements.size(); j++){
                if(elements.get(j).equals(x)){
                    return false;
                }
            }
        }

        return true;
    }
}
