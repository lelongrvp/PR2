package a3_1801040081;

/**
 * @overview
 * Display a report table in text of some PCs
 */
public class PCReport {
    /**
     * @requires <tt>pcs is not eq null</tt>
     * @effects
     *  generate and return a text-base report table of the PCs
     *
     *  <p> The report contain report title displayed in the middle of the first line.
     *  From second line onward will is display PC information
     *
     *  <p> more specific the first column after the title displays the row number with
     *  the width of 3, second column displays PC's model with the width of 20, third column
     *  displays PC's year with the width of 6, fourth column displays PC's manufacturer
     *  with the width of 20 and the fifth column displays PC's components with the width
     *  of 50. The cell value of each row are properly aligned and displayed right-justified.
     *  Further, the boundaries of two adjacent cells on the same row are exactly one space
     *  apart.
     *
     *  <p>e.g<br>
     *  -------------------------------------------------------------------------------------------
     *                                        PCPROG REPORT
     *  -------------------------------------------------------------------------------------------
     *     1          Vostro 3650MT   2016   DELL   {Intel-Core-i3-6100 CPU, 4GB-DDR3L RAM, ...}
     *     2 ...
     *     3 ...
     *  -------------------------------------------------------------------------------------------
     */
    public String displayReport(PC[] pcs){
        int col1 = 3, col3 = 6, col5 = 50;
        String result;
        boolean maxModel = false, maxYear = false, maxManufacturer = false, maxComps = false;
        String s1, s2 = null, s3 = null, s4 = null, s5 = null;

        for(int i = 0; i < pcs.length; i++){
            if(pcs[i].getModel().length() == 20)
                maxModel = true;
            if(pcs[i].getYear() >= 100000)
                maxYear = true;
            if(pcs[i].getManufacturer().length() == 20)
                maxManufacturer = true;
            if(pcs[i].getComps().toArrayString().length() >= 50){
                maxComps = true;
            }
        }

        String split = "--------------------------------------------------------------------------------------------------\n";
        String title = "                                           PCPROG REPORT                                        \n";

        result = split + title + split;

        int index = 1;

        for(PC pc : pcs){
            s1 = String.format("%3d", index);

            if(!maxModel)
                s2 = String.format("%20s", pc.getModel());
            else
                s2 = String.format("%21s", pc.getModel());

            if(!maxYear)
                s3 = String.format("%6d", pc.getYear());
            else
                s3 = String.format("%7s", pc.getYear());

            if(!maxManufacturer)
                s4 = String.format("%20s", pc.getManufacturer());
            else
                s4 = String.format("%21s", pc.getManufacturer());

            if(!maxComps)
                s5 = String.format("%50s", pc.getComps().toArrayString());
            else
                s5 = String.format("%51s", pc.getComps().toArrayString());

            result += s1 + s2 + s3 + s4 + s5 + "\n";
            index++;
        }

        result += split;
        return result;
    }
}
