import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import zaidanarkaanjtk.BusinessFlight;
import zaidanarkaanjtk.EconomyFlight;
import zaidanarkaanjtk.Flight;
import zaidanarkaanjtk.Passenger;


public class AirportTest {
    @DisplayName("Given there is an economy flight")
    @Nested
    class EconomyFlightTest {
        private Flight economyFlight;

        @BeforeEach
        void setUp() {
            economyFlight = new EconomyFlight("1");
        }

        @Test
        void testEconomyFlightRegularPassenger() {
            Passenger mike = new Passenger("Mike", false);
            assertEquals("1", economyFlight.getId());
            assertTrue(economyFlight.addPassenger(mike));
            assertEquals(1, economyFlight.getPassengersList().size());
            assertEquals("Mike",
                    economyFlight.getPassengersList().get(0).getName());
            assertTrue(economyFlight.removePassenger(mike));
            assertEquals(0, economyFlight.getPassengersList().size());
        }
        @Test
        void testEconomyFlightVipPassenger() {
            Passenger james = new Passenger("James", true);
            assertEquals("1", economyFlight.getId());
            assertTrue(economyFlight.addPassenger(james));
            assertEquals(1, economyFlight.getPassengersList().size());
            assertEquals("James",
                    economyFlight.getPassengersList().get(0).getName());
            assertFalse(economyFlight.removePassenger(james));
            assertEquals(1, economyFlight.getPassengersList().size());
        }
    }

    @DisplayName("Given there is a business flight")
    @Nested
    class BusinessFlightTest {
        private Flight businessFlight;
        @BeforeEach
        void setUp() {
            businessFlight = new BusinessFlight("2");
        }
        @Test
        void testBusinessFlightRegularPassenger() {
            Passenger mike = new Passenger("Mike", false);
            assertFalse(businessFlight.addPassenger(mike));
            assertEquals(0, businessFlight.getPassengersList().size());
            assertFalse(businessFlight.removePassenger(mike));
            assertEquals(0, businessFlight.getPassengersList().size());
        }
        @Test
        void testBusinessFlightVipPassenger() {
            Passenger james = new Passenger("James", true);
            assertTrue(businessFlight.addPassenger(james));
            assertEquals(1, businessFlight.getPassengersList().size());
            assertFalse(businessFlight.removePassenger(james));
            assertEquals(1, businessFlight.getPassengersList().size());
        }
    }
}