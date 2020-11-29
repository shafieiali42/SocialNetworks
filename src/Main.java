import java.util.Scanner;

public class Main {


    public static void resultOfQuestion(int numberOfSubjects,
                                        MyLinkedList<String> subjectOfQuestions, int deep) {


    }

    public static MyMatrix mergeMatrix(MyLinkedList<MyMatrix> myMatrices){ //todo define mergedMatrix
        MyMatrix mergedMatrix =new MyMatrix();




        return mergedMatrix;
    }





















    public static void main(String[] args) {

        MyLinkedList<String> allPeoples =new MyLinkedList<>();
        MyLinkedList<String> allSubjects =new MyLinkedList<>();
        MyLinkedList<SocialNetwork> allNetworks=new MyLinkedList<>();



        Scanner myScanner = new Scanner(System.in);
        int numberOfSocialNetworks = myScanner.nextInt();
        MyLinkedList<MyMatrix> friendShipMatrixList = new MyLinkedList<>();
        MyLinkedList<MyMatrix> interestMatrixList = new MyLinkedList<>();
        for (int k = 0; k < numberOfSocialNetworks; k++) {

            int numberOfSubject = myScanner.nextInt();

            MyLinkedList<String> thisNetworksSubject =new MyLinkedList<>();
            MyLinkedList<String> thisNetworksPeople =new MyLinkedList<>();
            for (int i = 0; i < numberOfSubject; i++) {
                String subjectName =myScanner.next();
                thisNetworksSubject.addElement(subjectName);
                allSubjects.addElement(subjectName);
            }

            MyLinkedList<Row> rowsOfInterest = new MyLinkedList<>();
            int numberOfPeople = myScanner.nextInt();
            for (int i = 0; i < numberOfPeople; i++) { // define the i-th row of interest matrix:
                String peopleName = myScanner.next();
                allPeoples.addElement(peopleName);
                thisNetworksPeople.addElement(peopleName);
                int fi = myScanner.nextInt();
                if (fi == 0) {
                    continue;
                }
                MyLinkedList<Column> columns = new MyLinkedList<>();
                for (int j = 0; j < fi; j++) {
                    String compound = myScanner.next();
                    int indexOfDots = compound.indexOf(':');
                    int index = Integer.parseInt(compound.substring(0, indexOfDots));
                    double valueOfInterest = Double.parseDouble(compound.substring(indexOfDots + 1));
                    Column column = new Column(index, valueOfInterest,thisNetworksSubject.getElement(index));//todo
                    columns.addElement(column);
                }

                Row row = new Row(i, columns,peopleName);
                rowsOfInterest.addElement(row);
            }


            int r = myScanner.nextInt();

            MyLinkedList<Row> rowsOfFriendShip = new MyLinkedList<>();
            for (int i = 0; i < r; i++) { // define the i-th row of friendShip matrix:
                int personIndex = myScanner.nextInt();
                int di = myScanner.nextInt();
                MyLinkedList<Column> columns = new MyLinkedList<>();
                for (int j = 0; j < di; j++) {
                    String compound = myScanner.next();
                    int indexOfDots = compound.indexOf(':');
                    int index = Integer.parseInt(compound.substring(0, indexOfDots));
                    double valueOfFriendShip = Double.parseDouble(compound.substring(indexOfDots + 1));
                    Column column = new Column(index, valueOfFriendShip,thisNetworksPeople.getElement(index));
                    columns.addElement(column);
                }
                Row row = new Row(personIndex, columns,thisNetworksPeople.getElement(personIndex));
                rowsOfFriendShip.addElement(row);
            }

            MyMatrix interestMatrix = new MyMatrix(1, 2, rowsOfInterest);
            MyMatrix friendShipMatrix = new MyMatrix(1, 2, rowsOfFriendShip);
            SocialNetwork socialNetwork =new SocialNetwork(thisNetworksPeople,thisNetworksSubject,
                                                            interestMatrix,friendShipMatrix);




            allNetworks.addElement(socialNetwork);
            interestMatrixList.addElement(interestMatrix);
            friendShipMatrixList.addElement(friendShipMatrix);
        }

        MyMatrix interestMatrix = mergeMatrix(interestMatrixList);
        MyMatrix friendShipMatrix =mergeMatrix(friendShipMatrixList);

        int numberOfQuestions = myScanner.nextInt();
        for (int i = 0; i < numberOfQuestions; i++) {
            int numberOfSubject = myScanner.nextInt();
            MyLinkedList<String> subjectOfQuestions = new MyLinkedList<>();
            for (int j = 0; j < numberOfSubject; j++) {
                subjectOfQuestions.addElement(myScanner.next());
            }
            int deep = myScanner.nextInt();
            resultOfQuestion(numberOfSubject, subjectOfQuestions, deep);
        }


    }


}
