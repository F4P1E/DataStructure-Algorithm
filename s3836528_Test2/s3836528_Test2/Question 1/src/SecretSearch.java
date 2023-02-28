//Data Structure and Algorithms
//Date Create: 14/01/2023
//Student: Duong Phu Dong (s3836528)

public class SecretSearch {
    public static void main(String[] args) {
        SecretSearch secretSearch = new SecretSearch(-1, 1, 1, 1, -1, 0.5);
        System.out.println(secretSearch.minTimeA());
        System.out.println(secretSearch.timeFromA(0));
        System.out.println(secretSearch.pointC());
    }

    //Create a constructor that accepts six double XA, YA, VA, XB, YB and VB
    double XA, YA, VA, XB, YB, VB;

    public SecretSearch(double XA, double YA, double VA, double XB, double YB, double VB) {
        this.XA = XA;
        this.YA = YA;
        this.VA = VA;
        this.XB = XB;
        this.YB = YB;
        this.VB = VB;
    }

    //double minTimeA()
    public double minTimeA() {
        double minTimeA = Math.abs(YA / VA);
        return Double.parseDouble(String.format("%.6f", minTimeA));
    }

    private double calDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }

    public double timeFromA(double XZ) {
        double timeFromA = calDistance(XA, YA, XZ, 0) / VA;
        return Double.parseDouble(String.format("%.6f", timeFromA));
    }

    private boolean validatePointC(double x) {
        return calDistance(XA, YA, x, 0) / VA == calDistance(XB, YB, x, 0) / VB;
    }

    //double pointC
    public double pointC() {
        double start = XA;
        double end = XB;

        double middle = (start + end) / 2;
        while (!validatePointC(middle)) {
            double timeA = calDistance(XA, YA, middle, 0) / VA;
            double timeB = calDistance(XB, YB, middle, 0) / VB;

            if (timeA < timeB) {
                start = middle;
            } else {
                end = middle;
            }

            middle = (start + end) / 2;
        }

        return Double.parseDouble(String.format("%.6f", middle));
    }
}
