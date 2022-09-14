CREATE TABLE Customer (
	ID	VARCHAR2(30)	PRIMARY KEY,
	password	VARCHAR2(30)	NOT NULL,
	customer_name	VARCHAR2(15)	NOT NULL,
	Signup_Date	TIMESTAMP	DEFAULT SYSDATE	NOT NULL,
	UPDATE_Date	TIMESTAMP	DEFAULT SYSDATE	NOT NULL
);

CREATE TABLE Account (
	account_id	NUMBER	PRIMARY KEY,
	ID	VARCHAR2(30)	REFERENCES Customer(id)	NOT NULL,
	balance	NUMBER	NOT NULL,
	open_Date	TIMESTAMP	DEFAULT SYSDATE	NOT NULL
);

CREATE TABLE Transaction_class (
	transaction_class_id	NUMBER	PRIMARY KEY,
	transaction_class_name	VARCHAR2(30)	NOT NULL
);

CREATE TABLE Transaction (
	transaction_id	NUMBER	PRIMARY KEY,
	deposit_account_id	NUMBER	REFERENCES Account(account_id),
	withdraw_account_id	NUMBER	REFERENCES Account(account_id),
	transaction_class_id	NUMBER	REFERENCES Transaction_class(transaction_class_id)	NOT NULL,
	transaction_amount	NUMBER	NOT NULL,
	transaction_Date	TIMESTAMP	DEFAULT SYSDATE	NOT NULL
);