package ReeKarate;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import com.intuit.karate.junit5.Karate;
import com.linecorp.armeria.internal.shaded.reflections.vfs.Vfs;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.apache.commons.io.FileUtils;


import java.io.File;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


class StatusRunner {
    @Karate.Test
    Karate Report() {
       Results results = Runner.path("classpath:ReeKarate").tags("~@ignore").outputCucumberJson(true).parallel(5);
        generateReport(results.getReportDir());
        return Karate.run("Status").relativeTo(getClass());

    }

    public static void generateReport(String karateOutputPath) {
        Collection<File> jsonFiles = FileUtils.listFiles(new File(karateOutputPath), new String[]{"json"}, true);
        final List<String> jsonPaths = new ArrayList(jsonFiles.size());

        jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));

        File file = new File("target");

        Configuration con = new Configuration(file,"demo");
        ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, con);
        reportBuilder.generateReports();
    }
}





