package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    public Job() {
        this.id = nextId;
        nextId ++;
    }

    public Job(String aName, Employer aEmployer, Location aLocation, PositionType aPositionType, CoreCompetency aCoreCompetency) {
        this();
        this.name = aName;
        this.employer = aEmployer;
        this.location = aLocation;
        this.positionType = aPositionType;
        this.coreCompetency = aCoreCompetency;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return getId() == job.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return System.lineSeparator() +
                "ID: " + getId() + "\n" +
                "Name: " + getName() + "\n" +
                "Employer: " + getEmployer() + "\n" +
                "Location: " + getLocation() + "\n" +
                "Position Type: " + getPositionType() + "\n" +
                "Core Competency: " + getCoreCompetency() +
                System.lineSeparator();
    }

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        Employer emptyEmployer = new Employer("Data not available");
        if (employer.getValue().isEmpty()) {
            return emptyEmployer;
        } else {
            return employer;
        }
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        Location emptyLocation = new Location("Data not available");
        if (location.getValue().isEmpty()) {
            return emptyLocation;
        } else {
            return location;
        }
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        PositionType emptyPositionType = new PositionType("Data not available");
        if (positionType.getValue().isEmpty()) {
            return emptyPositionType;
        } else {
            return positionType;
        }
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        CoreCompetency emptyCoreCompetency = new CoreCompetency("Data not available");
        if (coreCompetency.getValue().isEmpty()) {
            return emptyCoreCompetency;
        } else {
            return coreCompetency;
        }
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    public int getId() {
        return id;
    }
}
