

public interface AtmInterface {

    Boolean CardValidator(String cardNumber);

    int deposit(Double value);

    int withdraw(Double value);


    double balanceinquiry();

    String history(int x);

}
