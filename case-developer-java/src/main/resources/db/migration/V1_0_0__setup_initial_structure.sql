CREATE TABLE IF NOT EXISTS address
(
	id       UUID PRIMARY KEY,
	street   VARCHAR(255) NOT NULL,
	number   VARCHAR(255) NOT NULL,
	city     VARCHAR(255) NOT NULL,
	zip_code VARCHAR(255) NOT NULL,
	country  VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS employment
(
	id                  UUID PRIMARY KEY,
	company_name        VARCHAR(255) NOT NULL,
	fulltime_salary     DECIMAL(10, 2),
	parttime_percentage DECIMAL(5, 2),
	franchise           DECIMAL(10, 2),
	premium_percentage  DECIMAL(5, 2)
);

CREATE TABLE IF NOT EXISTS participant
(
	id                      UUID PRIMARY KEY,
	name                    VARCHAR(255) NOT NULL,
	date_of_birth           DATE         NOT NULL,
	address_id              UUID,
	employment_id           UUID,
	investment_account_iban VARCHAR(255),

	FOREIGN KEY (address_id) REFERENCES address (id),
	FOREIGN KEY (employment_id) REFERENCES employment (id)
);
