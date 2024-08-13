// Full Name : Vincent Loh Hang Rong
// Full Time
// Declaration : This program is my own work
// Did not pass to my friends
//
// File Name : VincentLoh_A3.java

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.*;

class Olympic
{
    private int NO = 10;
    private int rank;
    private String country;
    private double [] score;

    public Olympic(String country)
    {
        this.country = country;
        score = new double [NO];
        processScores();
    }

    public Olympic (Olympic oly)
    {
        this(oly.country);
    }

    public void processScores()
    {
        for(int i = 0; i < getScoreArray().length; i++)
        {
            score [i] = Math.random() * 100;
        }
    }

    public double totalScores()
    {
        double total = 0;
        for(int i = 0; i < score.length; i++)
        {
            total += score [i];
        }
        return total;
    }

    public void set(int rank)
    {
        this.rank = rank;
    }

    public int getRank()
    {
        return rank;
    }

    public String getName()
    {
        return country;
    }

    private double [] getScoreArray()
    {
        return score;
    }

    public String toString()
    {
        return String.format("Rank %d : %s(%.2f)\n", getRank(), getName(), totalScores());
    }
}

class OlympicFrame extends JFrame implements ActionListener
{
    private JButton [] jbArray;
    private final String [] countryArray = {"Usa", "Spain", "China", "Japan", "Italy",
                                            "Germany", "France", "Brazil", "Netherland",
                                            "Poland", "Russia", "Ukraine"};
    private ArrayList <Olympic> alist = new ArrayList <Olympic> ();
    double [] scoreArray = new double [12];

    public OlympicFrame()
    {
        super("Olympic 2020");
        setLayout(new GridLayout(4, 3));
        constructAList(alist);

        // initialize the array
        jbArray = new JButton [countryArray.length];

        // initialize each of the buttons
        for(int i = 0; i < jbArray.length; i++)
        {
            Icon icon = new ImageIcon(String.valueOf(i + 1) + ".jpg");
            jbArray [i] = new JButton(icon);
            add(jbArray[i]);
        }

        // register the event to each button
        for (JButton jb : jbArray)
        {
            jb.addActionListener(this);
        }

        // loop to set rank to country
        for(int i = 0; i < scoreArray.length; i++)
        {
            double x = getScores(alist, alist.get(i).getName()) * -1;
            scoreArray[i] = x;
        }

        Arrays.sort(scoreArray);

        // make sure scores are in ascending order
        for(int i = 0; i < scoreArray.length; i++)
        {
            double x = scoreArray[i] * -1;
            scoreArray[i] = x;
        }

        // set the rank after arraysort
        for(int i = 0; i < scoreArray.length; i++)
        {
            alist.get(i).set(getRank(scoreArray, getScores(alist, alist.get(i).getName())));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Icon trophy = new ImageIcon("trophy.jpg");
        for(String country : countryArray)
        {
            ((JButton)e.getSource()).setText("Rank: " + getRank(scoreArray, getScores(alist, country)));
        }
        JOptionPane.showMessageDialog(null,getFinalRanking(),"Miss World 2020",
                                                JOptionPane.PLAIN_MESSAGE,trophy);	
    }

    private void constructAList(ArrayList <Olympic> alist)
    {
        for(String country : countryArray)
        {
            alist.add(new Olympic(country));
        }
    }

    private int getRank(double [] scoreArray, double d)
    {
        int rank = 0;
        for(int i = 0; i < scoreArray.length; i++)
        {
            if(d == scoreArray[i])
            {
                rank = ++i;
            }
        }
        return rank;
    }

    private String getFinalRanking()
    {
        Collections.sort(alist, new Comparator <Olympic> ()
        {
            public int compare(Olympic o1, Olympic o2)
            {
                return o1.getRank() - o2.getRank();
            }
        });

        String finalRank = "FINAL RANKING\n\n";
        for(int i = 0; i < alist.size(); i++)
        {
            finalRank += alist.get(i).toString() + "\n";
        }
        return finalRank;
    }

    private String getCountry(ArrayList <Olympic> alist, int n)
    {
        String country = "";
        for(Olympic olp : alist)
        {
            if(olp.getRank() == n)
            {
                country = olp.getName();
            }
        }
        return country;
    }

    private double getScores (ArrayList <Olympic> alist, String name)
    {
        double i = 0.0;
        for(Olympic olp : alist)
        {
            if(olp.getName() == name)
            {
                i = olp.totalScores();
            }
        }
        return i;
    }
} 

class VincentLoh_A3
{
    public static void main(String [] args)
    {
        OlympicFrame olp = new OlympicFrame();
        olp.setSize(1100, 900);
        olp.setVisible(true);
        olp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}