package a3_1801040081;

import utils.DomainConstraint;
import utils.AttrRef;
import utils.DOpt;
import utils.OptType;

/**
 * @overview giving infomation about the personal computer
 * @attribute
 * model            String
 * year             Integer     Int
 * manufacturer     String
 * comps            Set
 * @object
 * A typical PC is PC = {model, year, manufacturer, comps} where model(model), year(year), manufacturer(manufacturer), comps(comps)
 * @abstract_properties
 * mutable(model) = true /\ optional(model) = false /\ length(model) = 20 /\
 * mutable(year) = false /\ optional(year) = false /\ min(year) = 1940 /\
 * mutable(manufacturer) = false /\ optional(manufacturer) = false /\ length(manufacturer) = 20 /\
 * mutable(comps) = true /\ optional(comps) = false
 */
public class PC {
    @DomainConstraint(type = "String", mutable = true, optional = false, length = 20)
    private String model;
    public static final int LEN_MODEL = 20;

    @DomainConstraint(type = "Integer", mutable = false, optional = false, min = 1940)
    private int year;
    public static final int MIN_YEAR = 1940;

    @DomainConstraint(type = "String", mutable = false, optional = false, length = 20)
    private String manufacturer;
    public static final int LEN_MAN = 20;

    @DomainConstraint(type = "Set", mutable = true, optional = false)
    private Set comps;

    /**
     * check if model satisfies abstract properties
     *
     * @effects <pre>
     *     if model is not null /\ model is not empty /\ model.length <= 20
     *          return true
     *     else
     *          return false
     * </pre>
     */
    public boolean validateModel(String model) {
        return model != null && !model.isEmpty() && model.length() <= LEN_MODEL;
    }

    /**
     * check if year satisfies abstract properties
     *
     * @effects <pre>
     *     if year >= 1940
     *          return true
     *     else
     *          return false
     * </pre>
     */
    public boolean validateYear(int year) {
        return year >= MIN_YEAR;
    }

    /**
     * check if manufacturer satisfies abstract properties
     *
     * @effects <pre>
     *     if manufacturer is not null /\ manufacturer is not empty /\ manufacturer.length <= 20
     *          return true
     *     else
     *          return false
     * </pre>
     */
    public boolean validateManufacturer(String manufacturer) {
        return manufacturer != null && !manufacturer.isEmpty() && manufacturer.length() <= LEN_MAN;
    }

    /**
     * check if comps satisfies abstract properties
     *
     * @effects <pre>
     *     if comps is not null
     *          return true
     *     else
     *          return false
     * </pre>
     */
    public boolean validateComps(Set comps) {
        return comps != null;
    }

    public PC(@AttrRef("model") String model, @AttrRef("year") int year, @AttrRef("manufacturer") String manufacturer, @AttrRef("comps") Set comps) {
        if (!validateModel(model)) {
            System.err.println("Invalid model: " + model);
            return;
        }

        if (!validateYear(year)) {
            System.err.println("Invalid year: " + year);
            return;
        }

        if (!validateManufacturer(manufacturer)) {
            System.err.println("Invalid manufacturer: " + manufacturer);
            return;
        }

        if (!validateComps(comps)) {
            System.err.println("Invalid comps: " + comps);
            return;
        }

        setModel(model);
        this.year = year;
        this.manufacturer = manufacturer;
        setComps(comps);
    }

    /**
     * return PC's model
     *
     * @effects <tt>return model</tt>
     */
    @DOpt(type = OptType.Observer) @AttrRef("model")
    public String getModel() {
        return model;
    }

    /**
     * return PC's year
     *
     * @effects <tt>return year</tt>
     */
    @DOpt(type = OptType.Observer) @AttrRef("year")
    public int getYear() {
        return year;
    }

    /**
     * return PC's manufacturer
     *
     * @effects <tt>return manufacturer</tt>
     */
    @DOpt(type = OptType.Observer) @AttrRef("manufacturer")
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * return PC's comps
     *
     * @effects <tt>return comps</tt>
     */
    @DOpt(type = OptType.Observer) @AttrRef("comps")
    public Set getComps() {
        return comps.clone();
    }

    /**
     * change PC's model
     *
     * @modifies <tt>this.model</tt>
     * @effects <pre>
     *     if model satisfies abstract properties
     *          return true
     *     else
     *          return false
     * </pre>
     */
    @DOpt(type = OptType.Mutator) @AttrRef("model")
    public boolean setModel(String model) {
        if (validateModel(model)) {
            this.model = model;
            return true;
        }

        return false;
    }

    /**
     * change PC's comps
     *
     * @modifies <tt>this.comps</tt>
     * @effects <pre>
     *     if comps satisfies abstract properties
     *          return true
     *     else
     *          return false
     * </pre>
     */
    @DOpt(type = OptType.Mutator) @AttrRef("comps")
    public boolean setComps(Set comps) {
        if (validateComps(comps)) {
            this.comps = comps.clone();
            return true;
        }

        return false;
    }

    @Override
    public String toString() {

        return "PC:<" + model + "," + year + "," + manufacturer + "," + comps.toString() + ">.";
    }

    /**
     * check if the current object satisfies the abstract properties
     * @effects <pre>
     *     if this satisfies the abstract properties
     *          return true
     *     else
     *          return false
     * </pre>
     */
    public boolean repOK(){
        return validateModel(model) && validateYear(year) && validateManufacturer(manufacturer) &&validateComps(comps);
    }
}
