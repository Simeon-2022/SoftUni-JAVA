package p06_TirePressureMonitoringSystem;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class AlarmTest {

    @Test
    void whenTirePressureIsMoreThan21_ThenAlarmIsOn() {

        Sensor sensor = Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(22.0);

        Alarm alarm = new Alarm(sensor);
        alarm.check();

        assertTrue(alarm.getAlarmOn());
    }

    @Test
    void whenTirePressureIsLessThan17_ThenAlarmIsOn() {

        Sensor sensor = Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(16.0);

        Alarm alarm = new Alarm(sensor);
        alarm.check();

        assertTrue(alarm.getAlarmOn());
    }

    @Test
    void whenTirePressureIsBetween17And21_ThenAlarmIsOff() {

        Sensor sensor2 = new Sensor();
        sensor2.popNextPressurePsiValue();

        Sensor sensor = Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(18.0);

        Alarm alarm = new Alarm(sensor);
        alarm.check();

        assertFalse(alarm.getAlarmOn());
    }


}