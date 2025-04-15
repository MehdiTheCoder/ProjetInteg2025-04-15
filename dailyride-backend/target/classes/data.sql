-- Insert a test driver
INSERT INTO users (name, email, password, role, verified)
VALUES ('Test Driver', 'driver@test.com', '$2a$10$dL4az.HyupJ4ZVWMVfQUyOJ1pYnCZDPYAYNMYuZbj4lBqOXhGvQVi', 'DRIVER', true);

-- Insert a test passenger
INSERT INTO users (name, email, password, role, verified)
VALUES ('Test Passenger', 'passenger@test.com', '$2a$10$dL4az.HyupJ4ZVWMVfQUyOJ1pYnCZDPYAYNMYuZbj4lBqOXhGvQVi', 'PASSENGER', true);

-- Insert a test trip
INSERT INTO trips (available_seats, departure_time, end_location, music_allowed, pets_allowed, smoking_allowed, start_location, status, driver_id)
VALUES (4, DATEADD('DAY', 1, CURRENT_TIMESTAMP), 'Destination City', true, false, false, 'Origin City', 'ACTIVE', 1);

-- Insert a test booking
INSERT INTO bookings (status, passenger_id, trip_id)
VALUES ('CONFIRMED', 2, 1);

-- Insert a test payment
INSERT INTO payments (amount, method, payment_date, booking_id)
VALUES (25.00, 'CASH', CURRENT_TIMESTAMP, 1); 