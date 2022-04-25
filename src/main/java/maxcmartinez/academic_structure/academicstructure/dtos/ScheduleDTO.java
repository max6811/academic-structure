package maxcmartinez.academic_structure.academicstructure.dtos;

public class ScheduleDTO {
    private String end;
    private String start;
    private String dayOfTheWeek;

    public ScheduleDTO(String dayOfTheWeek, String start, String end) {
        this.dayOfTheWeek = dayOfTheWeek;
        this.start =start;
        this.end = end;
    }

    public ScheduleDTO(){}

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getDayOfTheWeek() {
        return dayOfTheWeek;
    }

    public void setDayOfTheWeek(String dayOfTheWeek) {
        this.dayOfTheWeek = dayOfTheWeek;
    }
}
