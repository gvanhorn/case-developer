INSERT INTO public.address (id, street, number, city, zip_code, country)
VALUES ('550e8400-e29b-41d4-a716-446655440000', 'Hoofdstraat', '1-a', 'Amsterdam', '1106AB', 'Nederland');

INSERT INTO public.employment (id, company_name, fulltime_salary, parttime_percentage, franchise, premium_percentage)
VALUES
	('550e8400-e29b-41d4-a716-446655440001', 'BeFrank', 60000, 1, 15599, 0.05);

INSERT INTO public.participant (id, name, date_of_birth, address_id, employment_id)
VALUES
	('550e8400-e29b-41d4-a716-446655440002', 'John Doe', '1965-01-01', '550e8400-e29b-41d4-a716-446655440000', '550e8400-e29b-41d4-a716-446655440001');

