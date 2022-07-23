
# Web Service SOAP with JaxWS

## Jax Web Service Server
```java
public class JaxWSServer {
    public static void main(String[] args) {
        String url = "http://0.0.0.0:8585/";
        Endpoint.publish(url, new BankService());
        System.out.println("Web service running in "+ url);
    }
}
``` 

## Account Class

```java
@XmlRootElement(name = "account")
@XmlAccessorType(XmlAccessType.FIELD)
public class Account {
@XmlAttribute
private Long id;
@XmlElement
private double balance;
private Date creationDate;
private boolean active;
    public Account() {
    }
    public Account(Long id, double balance, Date creationDate, boolean active) {
        this.id = id;
        this.balance = balance;
        this.creationDate = creationDate;
        this.active = active;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public Date getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
}
``` 

## BankService Class
```java
@WebService(name = "bankWS")
public class BankService {
@WebMethod(operationName = "conversionDHToEuro")
public double conversion(@WebParam(name = "amount") double amount){
return amount / 11;
}
    public Account getAccount(@WebParam(name = "accountId") Long id){
        return  new Account(id,Math.random()*8000,new Date(), true);
    }
    public List<Account> getAccounts(){
        List<Account> accounts = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            accounts.add(new Account((long) (i + 1),Math.random()*8000,new Date(), true));
        }
      return accounts;
    }
}
``` 

## WSDL Schema

![image](https://user-images.githubusercontent.com/62752474/180603483-1d191988-56fc-4c65-a6e2-599b84273b3b.png)
## XML Schema Definition

![image](https://user-images.githubusercontent.com/62752474/180603492-6147ae8e-fc81-4675-ae82-4e22f93a4bb6.png)

## Testing SOAP web service with SoapUI tool

### Create new project in SoapU

![image](https://user-images.githubusercontent.com/62752474/180603541-3920fa3a-ce30-4371-bd72-2e8bb521a1cd.png)

### Get the web services info from wsdl schema automatically

![image](https://user-images.githubusercontent.com/62752474/180603551-1435ae90-c593-4253-b7d9-48cb58229c3f.png)
### SOAP Request for get account web service

![image](https://user-images.githubusercontent.com/62752474/180603560-95598f5e-e5c3-48cb-b825-9d8aa9f49284.png)

### Get Account Response 

![image](https://user-images.githubusercontent.com/62752474/180603571-fb231739-5409-4929-8fb8-9e0f9f700a17.png)
