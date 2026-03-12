CREATE DATABASE SkyDefenderDB;
GO

USE SkyDefenderDB;
GO

CREATE TABLE dbo.Users (
    Id BIGINT IDENTITY(1,1) PRIMARY KEY,
    Username NVARCHAR(50) NOT NULL UNIQUE,
    PasswordHash NVARCHAR(255) NOT NULL,
    CreatedAt DATETIME2 DEFAULT SYSDATETIME()
);

INSERT INTO dbo.Users (Username, PasswordHash)
VALUES (N'player01', N'$2a$10$/uYIhxofBnplyHkuoVPWQu8WYVCDhSwFIeSfFjImo315mZEk/F/wy');