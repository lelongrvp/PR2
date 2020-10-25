package a3_1801040081;

import utils.DomainConstraint;

import static utils.TextIO.getln;
import static utils.TextIO.getlnInt;
import static utils.TextIO.putln;
import static utils.TextIO.writeFile;
import static utils.TextIO.writeStandardOutput;

/**
 * @overview PCProg is a program that captures data about PC objects
 *    and displays a report about them on the console.
 * 
 * @attributes
 *  objs  Set
 *  
 * @object
 *  A typical PCProg is {c1,...,cn} where c1,...,cn are pcs
 * 
 * @abstract_properties
 *  mutable(objs)=true /\ optional(objs)=false
 * 
 * @author dmle
 */
public class PCProg {
  @DomainConstraint(type="Set",mutable=true,optional=false)
  private Set objs;
  
  /**
   * @effects
   *  initialise this to have an empty set of PCs
   */
  public PCProg() {
    objs = new Set();
  }

  /**
   * create new PC object base on user's data
   * @effects <pre>
   *      ask user to input PC's data
   *      if PC's data are valid
   *          add PC to a Set then ask user if (s)he want to add more user or not
   *             if yes
   *                invoke createObject
   *             else
   *                return
   *      else
   *          invoke createObject
   * </pre>
   */
  public void createObjects(){
      String model, manufacturer;
      int year;
      Set comps = new Set();

      putln("Enter PC's model: ");
      model = getln();
      putln("Enter PC's year: ");
      year = getlnInt();
      putln("Enter PC's manufacturer: ");
      manufacturer = getln();
      putln("Enter PC's comps: (enter nothing to quit)");

      while(true){
          String comp = getln();

          if(comp.isEmpty() || comp.isBlank())
              break;
          else
              comps.insert(comp);
      }
      PC pc = new PC(model, year, manufacturer, comps.clone());

      if(!pc.repOK()){
          createObjects();
      }
      else{
          objs.insert(pc);
          putln("Added " + pc.toString());

          putln("Do you want to add more pc? Y / N");
          String option = getln().toUpperCase();

          if(option.equals("Y"))
              createObjects();
          else
              return;
      }
  }


  /**
   * @effects
   *  if this has objects
   *    display a text-based tabular report and return this report
   *  else
   *    display nothing and return null
   */
  public String displayReport() {
    if (objs.size() > 0) {
      Object[] objsArr = objs.getObjects();
      PC[] pcs = new PC[objsArr.length];
      int i = 0;
      for (Object o : objsArr) {
        pcs[i++] = (PC) o;
      }
      
      PCReport reportObj = new PCReport();
      return reportObj.displayReport(pcs);
    } else {
      return null;
    }
  }
  
  /**
   * @effects 
   *  save report to a file pcs.txt in the same directory 
   *  as the program's
   */
  public void saveReport(String report) {
    String fileName = "pcs.txt";
    writeFile(fileName);
    putln(report);
    writeStandardOutput();
  }

  /**
   * The run method
   * @effects
   *  initialise an instance of PCProg 
   *  create objects from data entered by the user
   *  display a report on the objects 
   *  prompt user to save report to file
   *  if user answers "Y"
   *    save report 
   *  else
   *    end 
   */
  public static void main(String[] args) {
    //
    PCProg prog = new PCProg();
    
    // create objects
    prog.createObjects();
  
    // display report
    String report = prog.displayReport();
      
    if (report != null) {
      // prompt user to save report
      putln("Save report to file? [Y/N]");
      String toSave = getln();
      if (toSave.equals("Y")) {
        prog.saveReport(report);
        putln("report saved");
      }
    }
    
    putln("~END~");
  }
}
