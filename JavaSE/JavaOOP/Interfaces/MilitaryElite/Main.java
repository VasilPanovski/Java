package pr8_MilitaryElite;

import pr8_MilitaryElite.Interfaces.*;
import pr8_MilitaryElite.classes.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by mm on 12.7.2016 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Soldier> soldiers = new LinkedList<>();
        Map<String, Private> privates = new LinkedHashMap<>();

        String inputLine = null;
        while (!"End".equals(inputLine = reader.readLine())) {
            String[] params = inputLine.split("\\s+");
            String type = params[0];
            String id = params[1];
            String firstName = params[2];
            String lastName = params[3];
            double salary;
            String corps;

            switch (type) {
                case "Private":
                    salary = Double.valueOf(params[4]);
                    Private soldier = new PrivateImpl(id, firstName, lastName, salary);
                    soldiers.add(soldier);
                    privates.put(soldier.getId(), soldier);
                    break;

                case "LeutenantGeneral":
                    salary = Double.valueOf(params[4]);
                    List<Private> leutenantPrivates = new LinkedList<>();
                    for (int i = 5; i < params.length; i++) {
                        Private currentPrivet = privates.get(params[i]);
                        leutenantPrivates.add(currentPrivet);
                    }

                    Soldier leutenant = new LeutenantGeneralImpl(id, firstName, lastName, salary, leutenantPrivates);
                    soldiers.add(leutenant);
                    break;

                case "Engineer":
                    salary = Double.valueOf(params[4]);
                    corps = params[5];
                    List<Repair> repairs = new LinkedList<>();

                    for (int i = 6; i < params.length; i+=2) {
                        String repairName = params[i];
                        int workedHours = Integer.valueOf(params[i + 1]);

                        Repair repair = new RepairImpl(repairName, workedHours);
                        repairs.add(repair);
                    }
                    try {
                        Soldier engineer = new EngineerImpl(id, firstName, lastName, salary, corps, repairs);
                        soldiers.add(engineer);
                    } catch (IllegalArgumentException iae) {

                    }
                    break;

                case "Commando":
                    salary = Double.valueOf(params[4]);
                    corps = params[5];
                    List<Mission> missions = new LinkedList<>();
                    for (int i = 6; i < params.length; i+=2) {
                        String codeName = params[i];
                        try {
                            String state = params[i + 1];
                            Mission mission = new MissionImpl(codeName, state);
                            missions.add(mission);

                        } catch (IllegalArgumentException iae) {
                            //System.out.println(iae.getMessage());
                        }
                    }

                    try {
                        Soldier commando = new CommandoImpl(id, firstName, lastName, salary, corps, missions);
                        soldiers.add(commando);
                    } catch (IllegalArgumentException iae) {

                    }
                    break;
                case "Spy":
                    String codeNumber = params[4];
                    Soldier spy = new SpyImpl(id, firstName, lastName, codeNumber);
                    soldiers.add(spy);
                default:
                    break;
            }
        }

        for (Soldier soldier : soldiers) {
            System.out.println(soldier.toString());
        }
    }
}
