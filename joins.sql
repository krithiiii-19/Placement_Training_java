CREATE DATABASE PlacementPractice;
USE PlacementPractice;



-- Create Customer Table
CREATE TABLE Customer (
    CustomerID VARCHAR(10) PRIMARY KEY,
    CustomerName VARCHAR(50),
    DOB DATE,
    ContactNo VARCHAR(15)
);

-- Create PolicyType Table
CREATE TABLE PolicyType (
    PolicyType VARCHAR(20) PRIMARY KEY,
    PremiumRate DECIMAL(5,2), 
    CoverageYears INT
);

-- Create Branch Table
CREATE TABLE Branch (
    BranchID VARCHAR(10) PRIMARY KEY,
    BranchName VARCHAR(50),
    Manager VARCHAR(50)
);

-- Create Policy Table
CREATE TABLE Policy (
    PolicyID VARCHAR(10) PRIMARY KEY,
    CustomerID VARCHAR(10),
    PolicyType VARCHAR(20),
    PremiumAmount DECIMAL(10,2),
    BranchID VARCHAR(10),
    FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID),
    FOREIGN KEY (PolicyType) REFERENCES PolicyType(PolicyType),
    FOREIGN KEY (BranchID) REFERENCES Branch(BranchID)
);

-- Insert into Customer
INSERT INTO Customer (CustomerID, CustomerName, DOB, ContactNo) VALUES
('C1', 'Ramesh', '1985-05-10', '9876543210'),
('C2', 'Kavya', '1990-09-15', '9123456789');

-- Insert into PolicyType
INSERT INTO PolicyType (PolicyType, PremiumRate, CoverageYears) VALUES
('Health', 5.00, 10),
('Life', 8.00, 20),
('Vehicle', 6.00, 5);

-- Insert into Branch
INSERT INTO Branch (BranchID, BranchName, Manager) VALUES
('B1', 'Bangalore', 'Anil'),
('B2', 'Mysore', 'Sneha');

-- Insert into Policy
INSERT INTO Policy (PolicyID, CustomerID, PolicyType, PremiumAmount, BranchID) VALUES
('P1', 'C1', 'Health', 20000.00, 'B1'),
('P2', 'C1', 'Vehicle', 15000.00, 'B1'),
('P3', 'C2', 'Life', 50000.00, 'B2');

SELECT 
    b.BranchName, 
    MAX(p.PremiumAmount) AS MaxPremium
FROM Policy p
JOIN Branch b ON p.BranchID = b.BranchID
GROUP BY p.BranchID, b.BranchName;

SELECT 
    c.CustomerName, 
    COUNT(p.PolicyID) AS TotalPolicies
FROM Policy p
JOIN Customer c ON p.CustomerID = c.CustomerID
GROUP BY p.CustomerID, c.CustomerName
HAVING COUNT(p.PolicyID) > 1;

SELECT 
    b.BranchName, 
    SUM(p.PremiumAmount) AS TotalAnnualPremium
FROM Policy p
JOIN Branch b ON p.BranchID = b.BranchID
GROUP BY p.BranchID, b.BranchName;