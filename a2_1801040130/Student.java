package a2_1801040081;

import utils.DomainConstraint;
import utils.AttrRef;
import utils.DOpt;
import utils.OptType;
/**
*	@overview illustrate an university student's information
*	@attribute 
*	id 		Integer 	int
*	firstName 	String
*	givenName	String
*	lastName 	String
*	email 		String
*	address 	String
*	phone 		String
* 	dob 		String
* 	gender 		Gender
* 	@object
*	A typical university student is c = {id, firstName, givenName, lastName, email, address, phone, dob, gender}
*	where id(id), firstName(firstName), givenName(givenName), lastName(lastName),
*	email(email), address(address), phone(phone), dob(dob), gender(gender)
*	@abstract_properties
*	mutable(id) = false /\ optional(id) = false /\ min(id) = 1
*	mutable(firstName) = true /\ optional(firstName) = false /\ length(firstName) = 50
*	mutable(givenName) = true /\ optional(givenName) = false /\ length(givenName) = 50
*	mutable(lastName) = true /\ optional(lastName) = false /\ length(lastName) = 30
*	mutable(email) = true /\ optional(email) = true /\ length(email) = 255
*	mutable(address) = true /\ optional(address) = false /\ length(email) = 2000
*	mutable(phone) = true /\ optional(phone) = false /\ length(phone) = 20
*	mutable(dob) = false /\ optional(dob) = false /\ length(dob) = 20
*	mutable(gender) = false /\ optional(gender) = false 
*/
public class Student{
    @DomainConstraint(type = "Integer", mutable = false, optional = false, min = 1)
    private int id;

    @DomainConstraint(type = "String", mutable = true, optional = false, length = 50)
    private String firstName;

    @DomainConstraint(type = "String", mutable = true, optional = false, length = 50)
    private String givenName;

    @DomainConstraint(type = "String", mutable = true, optional = false, length = 30)
    private String lastName;

    @DomainConstraint(type = "String", mutable = true, optional = true, length = 255)
    private String email;

    @DomainConstraint(type = "String", mutable = true, optional = false, length = 2000)
    private String address;

    @DomainConstraint(type = "String", mutable = true, optional = false, length = 20)
    private String phone;

    @DomainConstraint(type = "String", mutable = false, optional = false, length = 20)
    private String dob;

    @DomainConstraint(type = "String", mutable = false, optional = false)
    private Gender gender;

    /**
     *	check if id satisfies abstract properties
     *	@effects<pre>
     *       if id >= 1
     *		    return true
     *       else
     *           return false</pre>
     */
    public boolean validateId(int id){
        return id >= 1;
    }

    /**
     *	check if firstName satisfies abstract properties
     *	@effects<pre>
     *       if firstName not null /\ firstName not empty /\ firstName.length() <= 50
     *		    return true
     *       else
     *           return false</pre>
     */
    public boolean validateFirstName(String firstName){
        return firstName != null && !firstName.isEmpty() && firstName.length() <= 50;
    }

    /**
     *	check if givenName satisfies abstract properties
     *	@effects<pre>
     *       if givenName not null /\ givenName not empty /\ givenName.length() <= 50
     *		    return true
     *       else
     *           return false</pre>
     */
    public boolean validateGivenName(String givenName){
        return givenName != null && !givenName.isEmpty() && givenName.length() <= 50;
    }

    /**
     *	check if lastName satisfies abstract properties
     *	@effects<pre>
     *       if lastName not null /\ lastName not empty /\ lastName.length() <= 30
     *		    return true
     *       else
     *           return false</pre>
     */
    public boolean validateLastName(String lastName){
        return lastName != null && !lastName.isEmpty() && lastName.length() <= 30;
    }

    /**
     *	check if email satisfies abstract properties
     *	@effects<pre>
     *       if email not null /\ email not empty /\ email.length() <= 255
     *		    return true
     *       else
     *           return false</pre>
     */
    public boolean validateEmail(String email){
        return email != null && !email.isEmpty() && email.length() <= 255;
    }

    /**
     *	check if address satisfies abstract properties
     *	@effects<pre>
     *       if address not null /\ address not empty /\ address.length() <= 2000
     *		    return true
     *       else
     *           return false</pre>
     */
    public boolean validateAddress(String address){
        return address != null && !address.isEmpty() && address.length() <= 2000;
    }

    /**
     *	check if phone satisfies abstract properties
     *	@effects<pre>
     *       if phone not null /\ phone not empty /\ phone.length() <= 20
     *		    return true
     *       else
     *           return false</pre>
     */
    public boolean validatePhone(String phone){
        return phone != null && !phone.isEmpty() && phone.length() <= 20;
    }

    /**
     *	check if dob satisfies abstract properties
     *	@effects<pre>
     *       if dob not null /\ dob is not empty /\ dob.length() <= 20
     *		return true
     *       else
     *		return false</pre>
     */
    public boolean validateDob(String dob){
        return dob != null && !dob.isEmpty() && dob.length() <= 20;
    }

    /**
     *	check if gender satisfies abstract properties
     *	@effects<pre>
     *       if gender not null
     *		return true
     *       else
     *		return false</pre>
     */
    public boolean validateGender(Gender gender){
        return gender != null;
    }

    /**
    * construct non optional attribute
    * @effects<pre>
    *  if id, firstName, givenName, lastName, address, phone, dob, gender
    *      initialise this as <id, name, firstName, givenName, lastName, address, phone, dob, gender>
    *  else   
    *      initialise this as <> and print error</pre>
    */
    public Student( @AttrRef("id") int id, @AttrRef("firstName") String firstName, @AttrRef("givenName") String givenName,
                        @AttrRef("lastName") String lastName, @AttrRef("address") String address, @AttrRef("phone") String phone,
                        @AttrRef("dob") String dob, @AttrRef("gender") Gender gender){
        if(!validateId(id)){
            System.err.println("Invalid id: " + id);
            return;
        }

        if(!validateFirstName(firstName)){
            System.err.println("Invalid firstName: " + firstName);
            return;
        }
                
        if(!validateGivenName(givenName)){
            System.err.println("Invalid givenName: " + givenName);
            return;
        }
                
        if(!validateLastName(lastName)){
            System.err.println("Invalid lastName: " + lastName);
            return;
        }

        if(!validateEmail(address)){
            System.err.println("Invalid address: " + address);
            return;
        }

        if(!setPhone(phone)){
            System.err.println("Invalid phone: " + phone);
            return;
        }
                
        if(!validateDob(dob)){
            System.err.println("Invalid dob: " + dob);
            return;
        }

        if(!validateGender(gender)){
            System.err.println("Invalid gender: " + gender);
            return;
        }

        this.id = id;
        setFirstName(firstName);
        setGivenName(givenName);
        setLastName(lastName);
        setAddress(address);
        setPhone(phone);
        this.dob = dob;
        this.gender = gender;
    }

    /**
    *	return student's id
    *	@effect return id of the student
    */
    @DOpt(type=OptType.Observer) @AttrRef("id")
    public int getId(){
        return id;
    }

    /**
    *	return student's first name
    *	@effect return first name of the student
    */
    @DOpt(type=OptType.Observer) @AttrRef("firstName")
    public String getFirstName(){
        return firstName;
    }

    /**
    *	return student's given name
    *	@effect return given name of the student
    */
    @DOpt(type=OptType.Observer) @AttrRef("givenName")
    public String getGivenName(){
        return givenName;
    }

    /**
    *	return student's last name
    *	@effect return last name of the student
    */
    @DOpt(type=OptType.Observer) @AttrRef("lastName")
    public String getLastName(){
        return lastName;
    }

    /**
    *	return student's email
    *	@effect return email of the student
    */
    @DOpt(type=OptType.Observer) @AttrRef("email")
    public String getEmail(){
        return email;
    }

    /**
    *	return student's address
    *	@effect return address of the student
    */
    @DOpt(type=OptType.Observer) @AttrRef("address")
    public String getAddress(){
        return address;
    }

    /**
    *	return student's phone
    *	@effect return phone of the student
    */
    @DOpt(type=OptType.Observer) @AttrRef("phone")
    public String getPhone(){
        return phone;
    }

    /**
    *	return student's dob
    *	@effect return dob of the student
    */
    @DOpt(type=OptType.Observer) @AttrRef("dob")
    public String getDob(){
        return dob;
    }

    /**
    *	return student's gender
    *	@effect return gender of the student
    */
    @DOpt(type=OptType.Observer) @AttrRef("gender")
    public Gender getGender(){
        return gender;
    }

    /**
    *	change student's first name
    * 	@modifies <tt>this.firstName</tt>
    *	@effects <pre>
    *       if firstName is not null /\ firstName is not empty /\ firstName.length() <= 50
    *           set this.firstName to firstName
    *           return true
    *       else 
    *           return false</pre>
    */
    @DOpt(type=OptType.Mutator) @AttrRef("firstName")
    public boolean setFirstName(String firstName){
        if(validateFirstName(firstName)){
            this.firstName = firstName;
            return true;
        }

        return false;
    }

    /**
    *	change student's first name
    * 	@modifies <tt>this.firstName</tt>
    *	@effects <pre>
    *       if givenName is not null /\ givenName is not empty /\ firstName.length() <= 50
    *           set this.givenName to givenName
    *           return true
    *       else 
    *           return false</pre>
    */
    @DOpt(type=OptType.Mutator) @AttrRef("givenName")
    public boolean setGivenName(String givenName){
        if(validateGivenName(givenName)){
            this.givenName = givenName;
            return true;
        }

        return false;
    }

    /**
    *	change student's last name
    * 	@modifies <tt>this.lastName</tt>
    *	@effects <pre>
    *       if lastName is not null /\ lastName is not empty /\  lastName.length() <= 30
    *          set this.lastName to lastName
    *          return true
    *       else 
    *          return false</pre>
    */
    @DOpt(type=OptType.Mutator) @AttrRef("lastName")
    public boolean setLastName(String lastName){
        if(validateLastName(lastName)){
            this.lastName = lastName;
            return true;
        }

        return false;
    }

    /**
     *	change student's email
     * 	@modifies <tt>this.email</tt>
     *	@effects <pre>
     *       if email is not null /\ email is not empty /\  email.length() <= 255
     *          set this.lastName to lastName
     *          return true
     *       else
     *          return false</pre>
     */
    @DOpt(type=OptType.Mutator) @AttrRef("lastName")
    public boolean setEmail(String email){
        if(validateEmail(email)){
            this.email = email;
            return true;
        }

        return false;
    }


    /**
    *	change student's address
    * 	@modifies <tt>this.address</tt>
    *	@effects <pre>
    *       if address is not null /\ address is not empty /\ address.length() <= 2000
    *           set this.address to address
    *           return true
    *       else 
    *           return false</pre>
    */
    @DOpt(type=OptType.Mutator) @AttrRef("address")
    public boolean setAddress(String address){
        if(validateAddress(address)){
            this.address = address;
            return true;
        }

        return false;
    }


    /**
    *	change student's phone number
    * 	@modifies <tt>this.phone</tt>
    *	@effects<pre>
    *       if phone is not null /\ phone is not empty /\ phone.length() <= 20
    *           set this.phone to phone
    *           return true
    *       else 
    *           return false</pre>
    */
    @DOpt(type=OptType.Mutator) @AttrRef("phone")
    public boolean setPhone(String phone){
        if(validatePhone(phone)){
            this.phone = phone;
            return true;
        }

        return false;
    }



    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", firstName=" + firstName + ", givenName=" + givenName + ", lastName=" + lastName + ", email=" + email + ", address=" + address + ", phone=" + phone + ", dob=" + dob + ", gender=" + gender + '}';
    }
         
    /**
    *	check if the current object satisfies the abstract properties
    *	@effects<pre>
    *       if this satisfies abstract properties
    *           return true
    *       else
    *          return false</pre>
    */
    public boolean repOK(){
        if(validateId(id) && validateFirstName(firstName) && validateGivenName(givenName) && validateLastName(lastName) && validateAddress(address) && validatePhone(phone) &&  validateDob(dob) && validateGender(gender)){
            return true;
        }

        return false;
    }
}



