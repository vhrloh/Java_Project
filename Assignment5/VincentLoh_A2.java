import java.util.Random;
import java.util.ArrayList;

enum ShapeColor {Blue, Yellow, Red, Green, White};

interface ForTwoD
{
    public void recolor(ShapeColor sc);
}

interface Shape
{
    public double area();
}

interface ForThreeD
{
    public void resize(double percentage);
}

abstract class TwoD implements Shape, ForTwoD
{
    protected ShapeColor sc;
    protected int a;
    protected int b;
    protected int c;
    protected int d;

    public TwoD()
    {

    }

    public TwoD(ShapeColor sc, int a)
    {
        this.sc = sc;
        this.a = a;
    }

    public TwoD(ShapeColor sc, int a, int b)
    {
        this.sc = sc;
        this.a = a;
        this.b = b;
    }

    public TwoD(ShapeColor sc, int a, int b, int c)
    {
        this.sc = sc;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public TwoD(ShapeColor sc, int a, int b, int c, int d)
    {
        this.sc = sc;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public TwoD(TwoD td)
    {
        this(td.sc, td.a, td.b, td.c, td.d);
    }

    public int getA()
    {
        return a;
    }

    public int getB()
    {
        return b;
    }

    public int getC()
    {
        return c;
    }

    public int getD()
    {
        return d;
    }

    public ShapeColor getShapeColor()
    {
        return sc;
    }

    public void set(ShapeColor sc, int a)
    {
        this.sc = sc;
        this.a = a;
    }

    public void set(ShapeColor sc, int a, int b)
    {
        this.sc = sc;
        this.a = a;
        this.b = b;
    }

    public void set(ShapeColor sc, int a, int b, int c)
    {
        this.sc = sc;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void set(ShapeColor sc, int a, int b, int c, int d)
    {
        this.sc = sc;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public void recolor(ShapeColor sc)
    {
        this.sc = sc;
    }

    public String toString()
    {
        if(b == 0 && c == 0 && d == 0)
        {
            return String.format("%s (2D, %s, %d)", getClass().getName(), sc, getA());
        }
        else if(c == 0 && d == 0)
        {
            return String.format("%s (2D, %s, %d, %d)", getClass().getName(), sc, getA(), getB());
        }
        else if(d == 0)
        {
            return String.format("%s (2D, %s, %d, %d, %d", getClass().getName(), sc, getA(), getB(), getC()); 
        }
        else
        {
            return String.format("%s (2D, %s, %d, %d, %d, %d", getClass().getName(), sc, getA(), getB(), getC(), getD());
        }
    }
}

class Circle extends TwoD
{
    public Circle()
    {

    }

    public Circle(ShapeColor sc, int radius)
    {
        super(sc, radius);
    }

    public Circle(Circle c)
    {
        this(c.sc, c.a);
    }

    @Override

    public double area()
    {
        double ca;
        ca = Math.PI * a * a;
        return ca;
    }

    public double perimeter()
    {
        double cp;
        cp = 2 * Math.PI * a;
        return cp;
    }

    public int getRadius()
    {
        return getA();
    }

    public void set(ShapeColor sc, int radius)
    {
        this.sc = sc;
        this.a = radius;
    }

    @Override

    public String toString()
    {
        return super.toString();
    }
}

class Rectangle extends TwoD
{
    public Rectangle()
    {

    }

    public Rectangle(ShapeColor sc, int length, int width)
    {
        super(sc, length, width);
    }

    public Rectangle(Rectangle r)
    {
        this(r.sc, r.a, r.b);
    }

    @Override

    public double area()
    {
        return a * b;
    }

    public double perimeter()
    {
        return 2 * (a + b);
    }

    public int getLength()
    {
        return getA();
    }

    public int getWidth()
    {
        return getB();
    }

    public void set(ShapeColor sc, int length, int width)
    {
        this.sc = sc;
        this.a = length;
        this.b = width;
    }

    @Override

    public String toString()
    {
        return super.toString();
    }
}

class Triangle extends TwoD
{
    public Triangle()
    {

    }

    public Triangle(ShapeColor sc, int a, int b, int c)
    {
        super(sc, a, b, c);
    }

    public Triangle(Triangle t)
    {
        this(t.sc, t.a, t.b, t.c);
    }

    @Override

    public double area()
    {
        double ta = (a + b + c) / 2.0;
        return Math.sqrt(ta * (ta - a) * (ta - b) * (ta - c));
    }

    public double perimeter()
    {
        double tp = a + b + c;
        return tp;
    }

    public int getA()
    {
        return a;
    }

    public int getB()
    {
        return b;
    }

    public int getC()
    {
        return c;
    }

    public void set(ShapeColor sc, int a, int b, int c)
    {
        this.sc = sc;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override

    public String toString()
    {
        return super.toString();
    }
}

class Trapezoid extends TwoD
{
    private int h;

    public Trapezoid()
    {

    }

    public Trapezoid(ShapeColor sc, int a, int b, int c, int d, int h)
    {
        super(sc, a, b, c, d);
        this.h = h;
    }

    public int getA()
    {
        return a;
    }

    public int getB()
    {
        return b;
    }

    public int getC()
    {
        return c;
    }

    public int getD()
    {
        return d;
    }

    public int getHeight()
    {
        return h;
    }

    @Override

    public double area()
    {
        return (((a + b) / 2.0)) * h;
    }

    public void set(ShapeColor sc, int a, int b, int c, int d, int h)
    {
        this.sc = sc;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.h = h;
    }

    @Override

    public String toString()
    {
        return String.format("%s, %d)", super.toString(), h);
    }
}

abstract class ThreeD implements Shape, ForThreeD
{
    protected ShapeColor sc;
    protected double a;

    public ThreeD()
    {

    }

    public ThreeD(ShapeColor sc, double a)
    {
        this.sc = sc;
        this.a = a;
    }

    public ThreeD(ThreeD td)
    {
        this(td.sc, td.a);
    }

    public double getA()
    {
        return getA();
    }

    public void set(ShapeColor sc, double a)
    {
        this.sc = sc;
        this.a = a;
    }

    public void resize(double percentage)
    {
        double resize = a * (percentage / 100);
        a = a - resize;
    }

    public double volume()
    {
        return a * a * a;
    }

    public String toString()
    {
        return String.format("%s (3D (%s, %.3f))", getClass().getName(), sc, a);
    }
}

class Sphere extends ThreeD
{
    public Sphere()
    {

    }

    public Sphere(ShapeColor sc, double a)
    {
        super(sc, a);
    }

    public Sphere(Sphere s)
    {
        this(s.sc, s.a);
    }

    @Override

    public double area()
    {
        return 4 * (Math.PI * (a * a));
    }

    @Override

    public double volume()
    {
        return (4.0 / 3) * Math.PI * super.volume();
    }

    public double getA()
    {
        return getA();
    }

    public void set(ShapeColor sc, double a)
    {
        this.sc = sc;
        this.a = a;
    }

    @Override

    public String toString()
    {
        return super.toString();
    }
}

class Cube extends ThreeD
{
    public Cube()
    {

    }

    public Cube(ShapeColor sc, double a)
    {
        super(sc, a);
    }

    public Cube(Sphere c)
    {
        this(c.sc, c.a);
    }

    @Override

    public double area()
    {
        return 6 * (a * a);
    }

    @Override

    public double volume()
    {
        return super.volume();
    }

    public double getA()
    {
        return a;
    }

    public void set(ShapeColor sc, double a)
    {
        this.sc = sc;
        this.a = a;
    }

    @Override

    public String toString()
    {
        return super.toString();
    }
}

class Tetrahedron extends ThreeD
{
    public Tetrahedron()
    {

    }

    public Tetrahedron(ShapeColor sc, double a)
    {
        super(sc, a);
    }

    public Tetrahedron(Tetrahedron t)
    {
        this(t.sc, t.a);
    }

    @Override

    public double area()
    {
        return Math.sqrt(3) * (a * a);
    }

    @Override

    public double volume()
    {
        return super.volume() / (6 * Math.sqrt(2));
    }

    public double getA()
    {
        return getA();
    }

    public void set(ShapeColor sc, double a)
    {
        this.sc = sc;
        this.a = a;
    }

    @Override

    public String toString()
    {
        return super.toString();
    }
}

public class VincentLoh_A2
{
    private static int getInt()
    {
        int rnum = (int)(Math.random() * 10) + 1;
        return rnum;
    }

    private static double getDouble()
    {
        double rnum2 = (Math.random() * 10) + 1;
        return rnum2;
    }

    private static ShapeColor getColor()
    {
        int clrlist = (int)(Math.random() * 4);
        switch(clrlist)
        {
            case(0): return ShapeColor.White;
            case(1): return ShapeColor.Blue;
            case(2): return ShapeColor.Red;
            case(3): return ShapeColor.Green;
            default: return ShapeColor.Yellow;
        }
    }

    private static boolean isTriangle(int a, int b, int c)
    {
        if((a > 0 && b > 0 && c > 0) && ((a + b) > c && (b + c) > a && (a + c) > b))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    private static TwoD getTwoD()
    {
        TwoD Shape = null;
        int a = getInt();
        int b = getInt();
        int c = getInt();
        int d = getInt();
        int h = getInt();
        int tdlist = (int)(Math.random() * 4);

        switch(tdlist)
        {
            case(0): Shape = new Circle(getColor(), a);
            break;
            case(1): Shape = new Rectangle(getColor(), a, b);
            break;
            case(2): if(isTriangle(a, b, c))
            {
                return new Triangle(getColor(), a, b, c);
            }
            else
            {
                while(!isTriangle(a, b, c))
                {
                    a = getInt();
                    b = getInt();
                    c = getInt();
                }

                Shape = new Triangle(getColor(), a, b, c);

            }
            break;
            default: Shape = new Trapezoid(getColor(), a, b, c, d, h);
            break;
        }
        return Shape;
    }

    private static ThreeD getThreeD()
    {
        ThreeD Shape = null;
        double a = getDouble();
        int trlist = (int)(Math.random() * 3);

        switch(trlist)
        {
            case(0): Shape = new Cube(getColor(), a);
            break;
            case(1): Shape = new Sphere(getColor(), a);
            break;
            default: Shape = new Tetrahedron(getColor(), a);
            break;
        }
        return Shape;
    }

    private static void displayList(ArrayList <Shape> alist)
    {
        int first = 1;
        int second = 1;

        for(Shape s:alist)
        {
            if(s instanceof ThreeD)
            {
                ThreeD trid = (ThreeD)s;
                System.out.println("");
                System.out.printf("Shape %d: %s%n", first, trid);
                System.out.printf("Surface Area = %.3f%n", trid.area());
                System.out.printf("Volume = %.3f%n", trid.volume());

                double percentage = getDouble();
                trid.resize(percentage);

                System.out.printf("Size reduced by %.1f%%: %s%n", percentage, trid);
                System.out.printf("Updated Surface Area = %.3f%n", trid.area());
                System.out.printf("Updated Volume = %.3f%n", trid.volume());
                System.out.printf("I am a %s Shape%n", trid.getClass().getName());
            }

            first++;

            if(s instanceof TwoD)
            {
                TwoD tudee = (TwoD)s;
                System.out.println("");
                System.out.printf("Shape %d: %s%n", second, tudee);

                ShapeColor preclr = tudee.getShapeColor();
                ShapeColor rplclr = getColor();

                while(preclr == rplclr)
                {
                    rplclr = getColor();

                    if(rplclr != preclr)
                    {
                        tudee.recolor(rplclr);
                    }
                    else
                    {
                        rplclr = getColor();
                    }
                }

                if(preclr != rplclr)
                {
                    tudee.recolor(rplclr);
                }

                System.out.printf("Updated Color: %s%n", tudee.getShapeColor());
                System.out.printf("Area: %.3f%n", tudee.area());
                System.out.printf("I am a %s Shape with color changed to %s%n", tudee.getClass().getName(), tudee.getShapeColor());
            }

            second++;
            System.out.println("===================================================");
                
        }
    }

    public static void main(String [] args)
    {
        ArrayList <Shape> alist = new ArrayList <Shape> ();
        int rnum3 = (int)(Math.random() * 3);

        do
        {
            if(rnum3 == 1)
            {
                TwoD td = getTwoD();
                alist.add(td);
            }
            else if(rnum3 == 2)
            {
                ThreeD threed = getThreeD();
                alist.add(threed);
            }
            rnum3 = (int)(Math.random() * 3);
        }

        while(rnum3 != 0);
            displayList(alist);
    }
}