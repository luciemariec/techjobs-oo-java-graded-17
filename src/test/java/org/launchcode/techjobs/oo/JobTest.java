package org.launchcode.techjobs.oo;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

import static org.junit.Assert.assertNotEquals;

public class JobTest {
    //TODO: Create your unit tests here

    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        //assertEquals(1, job.getId());
        assertEquals("Product tester", job.getName());
        assertTrue(job.getEmployer() instanceof Employer);
        assertEquals("ACME", job.getEmployer().getValue());
        assertTrue(job.getLocation() instanceof Location);
        assertEquals("Desert", job.getLocation().getValue());
        assertTrue(job.getPositionType() instanceof PositionType);
        assertEquals("Quality control", job.getPositionType().getValue());
        assertTrue(job.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence", job.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(job1.equals(job2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String expected = System.lineSeparator() +
                "ID: " + job.getId() + System.lineSeparator() +
                "Name: " + job.getName() + System.lineSeparator() +
                "Employer: " + job.getEmployer().getValue() + System.lineSeparator() +
                "Location: " + job.getLocation().getValue() + System.lineSeparator() +
                "Position Type: " + job.getPositionType().getValue() + System.lineSeparator() +
                "Core Competency: " + job.getCoreCompetency().getValue() + System.lineSeparator();
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String actual = job.toString();
        assertTrue(actual.contains("ID: " + job.getId()));
        assertTrue(actual.contains("Name: " + job.getName()));
        assertTrue(actual.contains("Employer: " + job.getEmployer().getValue()));
        assertTrue(actual.contains("Location: " + job.getLocation().getValue()));
        assertTrue(actual.contains("Position Type: " + job.getPositionType().getValue()));
        assertTrue(actual.contains("Core Competency: " + job.getCoreCompetency().getValue()));
    }


    @Test
    public void testToStringHandlesEmptyField() {
        Job job = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        String actual = job.toString();
        assertTrue(actual.contains("Name: Data not available"));
        assertTrue(actual.contains("Employer: Data not available"));
        assertTrue(actual.contains("Location: Data not available"));
        assertTrue(actual.contains("Position Type: Data not available"));
        assertTrue(actual.contains("Core Competency: Data not available"));
    }

}
