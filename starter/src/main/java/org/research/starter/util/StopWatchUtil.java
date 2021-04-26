package org.research.starter.util;

import org.springframework.util.StopWatch;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class StopWatchUtil extends StopWatch {

    public String prettyPrint(ArrayList<String> classNameList, HashMap<String, String> packageMap) {
        StringBuilder sb = new StringBuilder(shortSummary());
        sb.append('\n');
        sb.append("---------------------------------------------\n");
        sb.append("ns         %     Task name       Name\n");
        sb.append("---------------------------------------------\n");
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMinimumIntegerDigits(9);
        nf.setGroupingUsed(false);
        NumberFormat pf = NumberFormat.getPercentInstance();
        pf.setMinimumIntegerDigits(3);
        pf.setGroupingUsed(false);
        int i = 0;
        for (TaskInfo task : getTaskInfo()) {
            sb.append(nf.format(task.getTimeNanos())).append("  ");
            sb.append(pf.format((double) task.getTimeNanos() / getTotalTimeNanos())).append("  ");
            sb.append(task.getTaskName()).append("  ");
            sb.append(packageMap.get(classNameList.get(i))).append("\n");
            i++;
        }
        return sb.toString();
    }

}
