package TirePressureMonitoringSystem;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class TestAlarm {

    private Alarm alarm;

    @Mock
    private Sensor sensor;

    @Before
    public void initialize() {
        this.alarm = new Alarm();
        this.sensor = Mockito.mock(Sensor.class);
    }

    @Test
    public void alarmWithLowPressureShouldActiveTheAlarm() {
        //every time when the popNextPressurePsiValue is run we want to return 10.10 to see if the alarm is turned on
        Mockito.when(this.sensor.popNextPressurePsiValue()).thenReturn(10.10);

        this.alarm.check(this.sensor);

        Assert.assertTrue(this.alarm.getAlarmOn());
    }

    @Test
    public void alarmWithHightPressureShouldActiveTheAlarm() {
        Mockito.when(this.sensor.popNextPressurePsiValue()).thenReturn(35.2);

        this.alarm.check(this.sensor);

        Assert.assertTrue(this.alarm.getAlarmOn());
    }

    @Test
    public void alarmWithMiddlePressureShouldNotActiveTheAlarm() {
        Mockito.when(this.sensor.popNextPressurePsiValue()).thenReturn(18.2);

        this.alarm.check(this.sensor);

        Assert.assertFalse(this.alarm.getAlarmOn());
    }
}
