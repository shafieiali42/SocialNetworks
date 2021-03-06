import java.util.Scanner;

public class Main {


    public static SocialNetwork mergeSocialNetworks(MyLinkedList<SocialNetwork> socialNetworks,
                                                    MyLinkedList<String> allPeoples,
                                                    MyLinkedList<String> subjects) {
        if (socialNetworks.getSize() == 1) {
            return socialNetworks.getElement(0);
        }

        MyLinkedList<Row> rowsOfInterestMatrix = new MyLinkedList<>();
        int rowCounter = 0;

        for (int i = 0; i < allPeoples.getSize(); i++) {
            Row row = new Row(i, new MyLinkedList<Column>(), allPeoples.getElement(i));
            for (int j = 0; j < socialNetworks.getSize(); j++) {
                for (int k = 0; k < socialNetworks.getElement(j).getInterestMatrix().getRows().getSize(); k++) {
                    if (socialNetworks.getElement(j).getInterestMatrix().getRows().getElement(k).getRowName().
                            equals(allPeoples.getElement(i))) {
                        row = Row.add(row, socialNetworks.getElement(j).getInterestMatrix().getRows().getElement(k), subjects);
                    }
                }
            }
            row.setRowIndex(rowCounter);
            rowCounter++;
            if (row.getColumns().getHead() != null) {
                rowsOfInterestMatrix.addElement(row);
            }
        }

        MyMatrix interestMatrix = new MyMatrix(rowsOfInterestMatrix.getSize(), 2, rowsOfInterestMatrix);

        MyLinkedList<Row> rowsOfFriendShipMatrix = new MyLinkedList<>();

        rowCounter = 0;
        for (int i = 0; i < allPeoples.getSize(); i++) {
            Row row = new Row(i, new MyLinkedList<Column>(), allPeoples.getElement(i));
            for (int j = 0; j < socialNetworks.getSize(); j++) {
                for (int k = 0; k < socialNetworks.getElement(j).getFriendShip().getRows().getSize(); k++) {
                    if (socialNetworks.getElement(j).getFriendShip().getRows().getElement(k).getRowName().
                            equals(allPeoples.getElement(i))) {
                        row = Row.add(row, socialNetworks.getElement(j).getFriendShip().getRows().getElement(k), allPeoples);
                    }
                }
            }
            row.setRowIndex(rowCounter);
            rowCounter++;
            if (row.getColumns().getHead() != null) {
                rowsOfFriendShipMatrix.addElement(row);
            }

        }

        MyMatrix friendShipMatrix = new MyMatrix(rowsOfFriendShipMatrix.getSize(), 1, rowsOfFriendShipMatrix);

        SocialNetwork socialNetwork = new SocialNetwork(allPeoples, subjects, interestMatrix, friendShipMatrix);
        return socialNetwork;
    }


    public static MyLinkedList<String> resultOfQuestion(int numberOfSubjects,
                                                        MyLinkedList<String> subjectOfQuestions,
                                                        int depth, SocialNetwork socialNetwork,
                                                        MyLinkedList<String> resultName) {

        MyMatrix oneDepthMatrix;
        MyMatrix twoDepthMatrix;
        MyMatrix threeDepthMatrix;

        if (depth == 0) {
            for (int i = 0; i < socialNetwork.getInterestMatrix().getRows().getSize(); i++) {
                double result = socialNetwork.getInterestMatrix().getFullRowsMatrix().getRows().getElement(i).sumOfElements();
                if (result != 0) {
                    resultName.addElement(socialNetwork.getPeoples().getElement(i));
                    System.out.print(socialNetwork.getPeoples().getElement(i) + " ");
                    System.out.printf("%6f", result);
                    System.out.println();
//                    System.out.println(socialNetwork.getPeoples().getElement(i) + " " + result);
                }
            }
        } else if (depth == 1) {
            resultName = resultOfQuestion(numberOfSubjects, subjectOfQuestions, 0, socialNetwork, resultName);
            oneDepthMatrix = MyMatrix.multiplyMatrix(socialNetwork.getFriendShip(),
                    socialNetwork.getInterestMatrix().getFullRowsMatrix(), socialNetwork.getSubjects());

            for (int i = 0; i < oneDepthMatrix.getRows().getSize(); i++) {
                boolean exist = false;
                double result = oneDepthMatrix.getRows().getElement(i).sumOfElements();
                if (result != 0) {
                    for (int j = 0; j < resultName.getSize(); j++) {
                        if (resultName.getElement(j).equals(socialNetwork.getPeoples().getElement(i))) {
                            exist = true;
                        }
                    }
                        if (!exist) {
                            System.out.print(socialNetwork.getPeoples().getElement(i) + " ");
                            System.out.printf("%6f", result);
                            System.out.println(" +");

//                            System.out.println(socialNetwork.getPeoples().getElement(i) + " " + result + " +");
                            resultName.addElement(socialNetwork.getPeoples().getElement(i));
                        }

                }
            }
        } else if (depth == 2) {
            resultName = resultOfQuestion(numberOfSubjects, subjectOfQuestions, 1, socialNetwork, resultName);
            twoDepthMatrix = MyMatrix.multiplyMatrix(socialNetwork.getFriendShip(),
                    MyMatrix.multiplyMatrix(socialNetwork.getFriendShip(),
                            socialNetwork.getInterestMatrix().getFullRowsMatrix(), socialNetwork.getSubjects()),
                    socialNetwork.getSubjects());

            for (int i = 0; i < twoDepthMatrix.getRows().getSize(); i++) {
                boolean exist = false;
                double result = twoDepthMatrix.getRows().getElement(i).sumOfElements();
                if (result != 0) {
                    for (int j = 0; j < resultName.getSize(); j++) {
                        if (resultName.getElement(j).equals(socialNetwork.getPeoples().getElement(i))) {
                            exist = true;
                        }
                    }
                    if (!exist) {
                        System.out.print(socialNetwork.getPeoples().getElement(i) + " ");
                        System.out.printf("%6f", result);
                        System.out.println(" ++");
//                            System.out.println(socialNetwork.getPeoples().getElement(i) + " " + result + " ++");
                        resultName.addElement(socialNetwork.getPeoples().getElement(i));
                    }

                }
            }
        } else if (depth == 3) {
            resultName = resultOfQuestion(numberOfSubjects, subjectOfQuestions, 2, socialNetwork, resultName);
            threeDepthMatrix = MyMatrix.multiplyMatrix(MyMatrix.multiplyMatrix(MyMatrix.multiplyMatrix(socialNetwork.getFriendShip(),
                    socialNetwork.getFriendShip(), socialNetwork.getSubjects()), socialNetwork.getFriendShip(),
                    socialNetwork.getSubjects()), socialNetwork.getInterestMatrix().getFullRowsMatrix(),
                    socialNetwork.getSubjects());

            for (int i = 0; i < threeDepthMatrix.getRows().getSize(); i++) {
                boolean exist = false;
                double result = threeDepthMatrix.getRows().getElement(i).sumOfElements();
                if (result != 0) {
                    for (int j = 0; j < resultName.getSize(); j++) {
                        if (resultName.getElement(j).equals(socialNetwork.getPeoples().getElement(i))) {
                            exist = true;
                        }
                    }
                    if (!exist) {
                        System.out.print(socialNetwork.getPeoples().getElement(i) + " ");
                        System.out.printf("%6f", result);
                        System.out.println(" +++");
//                            System.out.println(socialNetwork.getPeoples().getElement(i) + " " + result + " +++");
                        resultName.addElement(socialNetwork.getPeoples().getElement(i));
                    }
                }

        }
    }

        return resultName;
}


    public static void main(String[] args) {


        MyLinkedList<String> allPeoples = new MyLinkedList<>();
        MyLinkedList<String> allSubjects = new MyLinkedList<>();
        MyLinkedList<SocialNetwork> allNetworks = new MyLinkedList<>();


        Scanner myScanner = new Scanner(System.in);
        int numberOfSocialNetworks = myScanner.nextInt();
        MyLinkedList<MyMatrix> friendShipMatrixList = new MyLinkedList<>();
        MyLinkedList<MyMatrix> interestMatrixList = new MyLinkedList<>();
        for (int k = 0; k < numberOfSocialNetworks; k++) {

            int numberOfSubject = myScanner.nextInt();

            MyLinkedList<String> thisNetworksSubject = new MyLinkedList<>();
            MyLinkedList<String> thisNetworksPeople = new MyLinkedList<>();
            for (int i = 0; i < numberOfSubject; i++) {
                String subjectName = myScanner.next();
                thisNetworksSubject.addElement(subjectName);
//                allSubjects.addElement(subjectName);
            }
            for (int j = 0; j < thisNetworksSubject.getSize(); j++) {
                boolean exist = false;
                for (int i = 0; i < allSubjects.getSize(); i++) {
                    if (thisNetworksSubject.getElement(j).equals(allSubjects.getElement(i))) {
                        exist = true;
                    }
                }
                if (!exist) {
                    allSubjects.addElement(thisNetworksSubject.getElement(j));
                }
            }


            MyLinkedList<Row> rowsOfInterest = new MyLinkedList<>();
            int numberOfPeople = myScanner.nextInt();
            for (int i = 0; i < numberOfPeople; i++) { // define the i-th row of interest matrix:
                String peopleName = myScanner.next();
                boolean exist = false;
                for (int j = 0; j < allPeoples.getSize(); j++) {
                    if (allPeoples.getElement(j).equals(peopleName)) {
                        exist = true;
                    }
                }
                if (!exist) {
                    allPeoples.addElement(peopleName);
                }
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
                    Column column = new Column(index, valueOfInterest, thisNetworksSubject.getElement(index));//todo
                    columns.addElement(column);
                }

                Row row = new Row(i, columns, peopleName);
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
                    Column column = new Column(index, valueOfFriendShip, thisNetworksPeople.getElement(index));
                    columns.addElement(column);
                }
                Row row = new Row(personIndex, columns, thisNetworksPeople.getElement(personIndex));
                rowsOfFriendShip.addElement(row);
            }

            MyMatrix interestMatrix = new MyMatrix(numberOfPeople, numberOfSubject, rowsOfInterest);
            MyMatrix friendShipMatrix = new MyMatrix(numberOfPeople, numberOfPeople, rowsOfFriendShip);
            SocialNetwork socialNetwork = new SocialNetwork(thisNetworksPeople, thisNetworksSubject,
                    interestMatrix, friendShipMatrix);


            allNetworks.addElement(socialNetwork);
            interestMatrixList.addElement(interestMatrix);
            friendShipMatrixList.addElement(friendShipMatrix);
        }

        SocialNetwork socialNetwork = mergeSocialNetworks(allNetworks, allPeoples, allSubjects);
        MyMatrix interestMatrix = socialNetwork.getInterestMatrix();
        MyMatrix friendShipMatrix = socialNetwork.getFriendShip();

//        System.out.println(interestMatrix.getFullRowsMatrix());
//        System.out.println(MyMatrix.multiplyMatrix(friendShipMatrix,interestMatrix.getFullRowsMatrix(),allSubjects));

        int numberOfQuestions = myScanner.nextInt();
        for (int i = 0; i < numberOfQuestions; i++) {
            int numberOfSubject = myScanner.nextInt();
            MyLinkedList<String> subjectOfQuestions = new MyLinkedList<>();
            for (int j = 0; j < numberOfSubject; j++) {
                subjectOfQuestions.addElement(myScanner.next());
            }
            int depth = myScanner.nextInt();
            resultOfQuestion(numberOfSubject, subjectOfQuestions, depth, socialNetwork, new MyLinkedList<>());
        }


    }


}
