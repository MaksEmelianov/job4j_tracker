package ru.job4j.map;

import java.util.*;

public class AnalyzeByMap {

    public static double averageScore(List<Pupil> pupils) {
        double rsl = Double.NaN;
        if (!pupils.isEmpty()) {
            int countSub = 0;
            int sumScore = 0;
            for (var pupil : pupils) {
                for (var sub : pupil.subjects()) {
                    countSub++;
                    sumScore += sub.score();
                }
            }
            rsl = (double) sumScore / countSub;
        }
        return rsl;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        if (!pupils.isEmpty()) {
            int countSub = 0;
            int sumScore = 0;
            for (var pupil : pupils) {
                countSub = 0;
                sumScore = 0;
                for (var sub : pupil.subjects()) {
                    countSub++;
                    sumScore += sub.score();
                }
                rsl.add(
                        new Label(pupil.name(),
                                countSub == 0 || sumScore == 0 ? Double.NaN : (double) sumScore / countSub)
                );
            }
        }
        return rsl;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        if (!pupils.isEmpty()) {
            Map<String, Integer> map = new LinkedHashMap<>();
            int countSub = 0;
            int sumScore = 0;
            for (var pupil : pupils) {
                countSub++;
                for (var sub : pupil.subjects()) {
                    sumScore = map.get(sub.nameSub()) != null ? map.get(sub.nameSub()) : 0;
                    map.put(sub.nameSub(), sumScore += sub.score());
                }
            }
            for (var entry : map.entrySet()) {
                rsl.add(
                        new Label(entry.getKey(),
                                countSub == 0 || sumScore == 0 ? Double.NaN : (double) entry.getValue() / countSub)
                );
            }
        }
        return rsl;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        if (!pupils.isEmpty()) {
            ArrayList<Label> tmp = new ArrayList<>();
            int countSub = 0;
            int sumScore;
            for (var pupil : pupils) {
                countSub++;
                sumScore = 0;
                for (var sub : pupil.subjects()) {
                    sumScore += sub.score();
                }
                tmp.add(
                        new Label(pupil.name(), sumScore)
                );
            }
            tmp.sort(Comparator.naturalOrder());
            return tmp.get(countSub - 1);
        }
        return null;
    }

    public static Label bestSubject(List<Pupil> pupils) {
        if (!pupils.isEmpty()) {
            Map<String, Integer> map = new LinkedHashMap<>();
            int countSub = 0;
            int sumScore = 0;
            for (var pupil : pupils) {
                countSub++;
                for (var sub : pupil.subjects()) {
                    sumScore = map.get(sub.nameSub()) != null ? map.get(sub.nameSub()) : 0;
                    map.put(sub.nameSub(), sumScore += sub.score());
                }
            }
            List<Label> tmp = new ArrayList<>();
            for (var entry : map.entrySet()) {
                tmp.add(
                        new Label(entry.getKey(), entry.getValue())
                );
            }
            tmp.sort(Comparator.naturalOrder());
            return tmp.get(countSub - 1);
        }
        return null;
    }
}
