class PlacementRecord {
    String studentName;
    String company;
    double packageLpa;

    public PlacementRecord(String studentName, String company, double packageLpa) {
        this.studentName = studentName;
        this.company = company;
        this.packageLpa = packageLpa;
    }

    public void printRecord() {
        System.out.println(studentName + " -> " + company + " @ " + packageLpa + " LPA");
    }
}

public class M1_StudentPlacementRecordManagement {
    public static void main(String[] args) {
        PlacementRecord[] placements = new PlacementRecord[3];
        placements[0] = new PlacementRecord("Ravi", "TCS", 4.5);
        placements[1] = new PlacementRecord("Anitha", "Zoho", 6.2);
        placements[2] = new PlacementRecord("Karthik", "Infosys", 4.0);

        for (PlacementRecord record : placements) {
            record.printRecord();
        }
    }
}