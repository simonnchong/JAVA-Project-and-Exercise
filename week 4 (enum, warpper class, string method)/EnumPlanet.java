public enum EnumPlanet {//pg129
  MERCURY (3.303e+23, 2.4397e6),
  VENUS   (3.869e+24, 6.0518e6),
  EARTH   (5.976e+24, 6.37814e6),
  MARS    (6.421e+23, 3.3972e6),
  JUPITER (1.900e+27, 7.1492e7),
  SATURN  (5.688e+26, 6.0268e7),
  URANUS  (8.686e+25, 2.5559e7),
  NEPTUNE (1.024e+26, 2.4746e7);

  private final double mass;
  private final double radius;

  private double getMass() {return mass;}
  private double getRadius () {return radius;}

  EnumPlanet(double m, double r) {
    mass   = m;
    radius = r;
  }

  public static final double G = 6.67300E-11;

  public double surfaceGravity () {
    return G*mass/(radius*radius);
  }

  public double surfaceWeight (double m) {
    return m*surfaceGravity();
  }

  public static void main (String[] args) {
    double earthWeight = Double.parseDouble(args[0]);
    double mass        = earthWeight/EARTH.surfaceGravity();

    for (EnumPlanet p : EnumPlanet.values())
      System.out.printf("Your weight on %s is %.2f\n", p, p.surfaceWeight(mass));
  }
}

//javac EnumPlanet.java
//java  EnumPlanet 70