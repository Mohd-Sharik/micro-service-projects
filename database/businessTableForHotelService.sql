CREATE TABLE TB_RP_M_Hotel
(
ID							NUMBER(38, 0) NOT NULL,
NAME						NVARCHAR2(30),
LOCATION						VARCHAR2(2000) 	,
ABOUT     					NVARCHAR2(50)
);						
ALTER TABLE TB_RP_M_Hotel ADD CONSTRAINT M_Hotel_PK PRIMARY KEY(ID); 