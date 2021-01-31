class Clock {

    int hours = 12;
    int minutes = 0;

    void next() {
        if(minutes == 59) {
            minutes = 0;
            hours++;
        } else {
            minutes++;
        }

        if (hours == 13)
            hours = 1;

    }
}