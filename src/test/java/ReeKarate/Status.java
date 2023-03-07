package ReeKarate;

import com.intuit.karate.junit5.Karate;

    class Status {

        @Karate.Test
        Karate testStatus() {
            return Karate.run("Status").relativeTo(getClass());
        }

    }


