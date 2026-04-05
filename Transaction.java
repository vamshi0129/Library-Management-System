public class Transaction {
    int bookId;
    int userId;
    int issueDate;
    int returnDate;

    Transaction(int bookId , int userId , int issueDate , int returnDate){
        this.bookId = bookId;
        this.userId = userId;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
    }

}
