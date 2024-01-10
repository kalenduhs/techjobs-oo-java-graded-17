package org.launchcode.techjobs.oo;

import org.junit.Test;

import java.util.Objects;

import static java.lang.System.lineSeparator;
import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here

    @Test
    public void testSettingJobId () {
        Job job1 = new Job();
        Job job2 = new Job();

        assertNotEquals(job1, job2);
    }

    @Test
    public void testJobConstructorSetsAllFields () {
        Job job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(job3.getName(), "Product tester");
        assertEquals(job3.getEmployer().getValue(), "ACME");
        assertEquals(job3.getLocation().getValue(), "Desert");
        assertEquals(job3.getPositionType().getValue(), "Quality control");
        assertEquals(job3.getCoreCompetency().getValue(), "Persistence");

        assertTrue(job3 instanceof Job);
        assertTrue(job3.getEmployer() instanceof Employer);
        assertTrue(job3.getLocation() instanceof Location);
        assertTrue(job3.getPositionType() instanceof PositionType);
        assertTrue(job3.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality () {
        Job job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job5 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals(job4.equals(job5), false);
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine () {
        Job job6 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String firstChar = String.valueOf(job6.toString().charAt(0));
        String lastChar = String.valueOf(job6.toString().charAt(job6.toString().length()-1));
        assertEquals(firstChar, lineSeparator());
        assertEquals(lastChar, lineSeparator());
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData () {
        Job job7 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String testString = System.lineSeparator() +
                "ID: " + job7.getId() + "\n" +
                "Name: " + job7.getName() + "\n" +
                "Employer: " + job7.getEmployer() + "\n" +
                "Location: " + job7.getLocation() + "\n" +
                "Position Type: " + job7.getPositionType() + "\n" +
                "Core Competency: " + job7.getCoreCompetency() +
                System.lineSeparator();
        String compareString = job7.toString();
        assertEquals(testString, compareString);
    }

    @Test
    public void testToStringHandlesEmptyField () {
        Job job8 = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType(""), new CoreCompetency("Persistence"));
        String testString = System.lineSeparator() +
                "ID: " + job8.getId() + "\n" +
                "Name: " + job8.getName() + "\n" +
                "Employer: " + "Data not available" + "\n" +
                "Location: " + job8.getLocation() + "\n" +
                "Position Type: " + "Data not available" + "\n" +
                "Core Competency: " + job8.getCoreCompetency() +
                System.lineSeparator();
        String compareString = job8.toString();
        assertEquals(testString, compareString);
    }
}
