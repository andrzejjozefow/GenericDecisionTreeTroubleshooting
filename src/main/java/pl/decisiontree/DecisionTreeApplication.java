package pl.decisiontree;


public class DecisionTreeApplication {

    public static void main( String[] args ) {

        Branch podlaczWtyczke = new Leaf("Podlacz wtyczke!");
        Branch pomocTechniczna = new Leaf("Skontaktuj sie z pomoca techniczna");

        Branch czyPodlaczylesDoPradu = new YesNoBranch("Czy podlaczyles do prądu", pomocTechniczna, podlaczWtyczke);

        Branch zamknijKlape = new Leaf("Zamknij klapę!");
        Branch czyZamknalesKlape = new YesNoBranch("Czy zamknałes klape", czyPodlaczylesDoPradu, zamknijKlape);

        DecisionTree zepsutaPralkaTree = new DecisionTree(czyZamknalesKlape);

        String decisionTreeInJson = zepsutaPralkaTree.toJson();

        System.out.println("Decision tree json:" + decisionTreeInJson);

    }

}
