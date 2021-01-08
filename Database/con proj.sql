--Creare de tabele

--Cumparatori
create table
Cumparatori(
id_cumparator number(3) constraint cump_pk primary key, 
Persoana_Fizica number(1),
Persoana_Juridica number(1),
Denumire varchar2(35) constraint verif_den not null,
Semnatura varchar2(25) constraint unic_semn unique, 
CNP char(13) constraint unic_CNP unique, 
CI char(8) constraint unic_CI unique, 
Nr_Reg_Com varchar2(20) constraint unic_nr unique, 
CUI varchar2(10) constraint unic_cui unique,
Adresa varchar2(35) constraint verif_adr not null,
Contact char(10) constraint unic_contact unique not null,
Cod_postal char(6) constraint verif_cp not null,
Email varchar2(25) constraint unic_email unique not null,
Stampila varchar2(25) constraint unic_stamp unique,

constraint verif_PF check (Persoana_Fizica = 0 OR Persoana_Fizica = 1),
constraint verif_PJ check (Persoana_Juridica = 0 OR Persoana_Juridica = 1)
);

--Dotari
create table
Dotari(
id_dotare number(3) constraint dot_pk primary key,
Nume_dotare varchar2(65) constraint unic_nume unique not null,
Optional char(2) default 'Nu' constraint verif_opt not null check (Optional = 'Nu' OR Optional = 'Da')
);

--Taxe
create table
Taxe(
id_taxa number(3) constraint taxa_pk primary key,
Nume_taxa varchar2(45) constraint verif_num  not null,
Pret number(6,2) constraint verif_pr not null,
Clasa char(2) constraint verif_cls not null
);

--Furnizori
create table
Furnizori(
id_furnizor number(3) constraint furn_pk primary key,
Denumire varchar2(45) constraint verif_denu  not null unique,
Adresa varchar2(25) constraint verif_adre not null unique,
Oras varchar2(25) constraint verif_or not null,
Cod_postal char(6) constraint verif_co not null,
Stampila varchar2(25) constraint verif_stamp not null unique
);

--Tari
create table
Tari(
id_tara number(3) constraint tara_pk primary key,
Nume_tara varchar2(35) constraint verif_numt not null unique
);

--Locatii
create table
Locatii(
id_locatie number(3) constraint loc_pk primary key,
Adresa varchar2(25) constraint ver_adr not null unique,
Cod_postal char(6) constraint ver_cp not null,
Oras varchar2(25) constraint ver_ora not null,
id_tara constraint fk_id_tara references Tari(id_tara)
);

alter table LOCATII
drop constraint fk_id_tara;

alter table LOCATII
add constraint fk_id_tara foreign key(id_tara)
references TARI(id_tara) on delete cascade;

--Showroomuri
create table
Showroomuri(
id_showroom number(3) constraint show_pk primary key,
Denumire varchar2(35) constraint veri_den not null,
Ora_deschidere char(4) default '9:00' constraint ver_od not null,
Ora_inchidere char(5) default '21:00' constraint ver_oi not null,
Contact char(10) constraint un_contact unique not null,
Email varchar2(25) constraint un_email unique not null,
IBAN varchar2(24) constraint un_iban unique not null,
CIF varchar2(11) constraint un_cif unique not null,
Nr_Reg_Com varchar2(20) constraint un_nr unique not null,
Stampila varchar2(25) constraint un_stamp unique not null,
id_locatie constraint fk_id_locatie references Locatii(id_locatie)
);

alter table SHOWROOMURI
drop constraint fk_id_locatie;

alter table SHOWROOMURI
add constraint fk_id_locatie foreign key(id_locatie)
references LOCATII(id_locatie) on delete cascade;

--Dealeri
create table
Dealeri(
id_dealer number(3) constraint deal_pk primary key,
Nume varchar2(25) constraint ver_num not null,
Prenume varchar2(45) constraint ver_pren not null,
Telefon char(10) constraint uni_tel unique not null,
Semnatura varchar2(25) constraint un_semn unique not null, 
Email varchar2(25) constraint uni_email unique,
Domiciliu varchar2(25) constraint ver_dom not null,
id_showroom constraint fk_id_showroom references Showroomuri(id_showroom)
);

alter table DEALERI
drop constraint fk_id_showroom;

alter table DEALERI
add constraint fk_id_showroom foreign key(id_showroom)
references SHOWROOMURI(id_showroom) on delete set null;

--alter table DEALERI
--drop constraint fk_id_showroom;

--alter table DEALERI
--add constraint fk_id_showroom foreign key(id_showroom)
--references SHOWROOMURI(id_showroom) on delete cascade;

--Masini
create table
Masini(
id_masina number(3) constraint masi_pk primary key,
Model_Masina varchar2(35) constraint ver_mod not null,
Cai_putere number(4) constraint ver_cai not null,
An_fabricatie number(4) constraint ver_an_fb not null check (An_fabricatie >= 2005),
Combustibil varchar2(10) constraint ver_comb not null,
Kilometraj number(5) constraint ver_kilo not null,
Norma_poluare varchar2(10) constraint ver_norm not null,
Culoare varchar2(40) constraint ver_cul not null,
Tip_volan varchar2(10) constraint ver_vol not null,
Cutie_viteze varchar2(15) constraint ver_cut not null,
Transmisie varchar2(15) constraint ver_trans not null,
Numar_portiere number(1) constraint ver_port not null,
Pret number(10,2) constraint ver_pret not null,
id_cumparator constraint fk_id_cumparator references Cumparatori(id_cumparator),
id_furnizor constraint fk_id_furnizor references Furnizori(id_furnizor),
id_dealer constraint fk_id_dealer references Dealeri(id_dealer)
);

--
alter table MASINI
drop constraint fk_id_cumparator;

alter table MASINI
add constraint fk_id_cumparator foreign key(id_cumparator)
references CUMPARATORI(id_cumparator) on delete cascade;
--

--
alter table MASINI
drop constraint fk_id_furnizor;

alter table MASINI
add constraint fk_id_furnizor foreign key(id_furnizor)
references FURNIZORI(id_furnizor) on delete cascade;
--

--
alter table MASINI
drop constraint fk_id_dealer;

alter table MASINI
add constraint fk_id_dealer foreign key(id_dealer)
references DEALERI(id_dealer) on delete cascade;
--

--Pachete
create table
Pachete (
id_dotare number(3),
id_masina number(3),
Nume_pachet varchar2(25) constraint ver_nump not null, 
Pachet_continut varchar2(25),

constraint fk_id_pac_dotare foreign key (id_dotare) references Dotari(id_dotare),
constraint fk_id_pac_masina foreign key (id_masina) references Masini(id_masina),
constraint pac_pk primary key (id_dotare, id_masina)
);

--
alter table PACHETE
drop constraint fk_id_pac_dotare;

alter table PACHETE
add constraint fk_id_pac_dotare foreign key (id_dotare)
references DOTARI(id_dotare) on delete cascade;
--

--
alter table PACHETE
drop constraint fk_id_pac_masina;

alter table PACHETE
add constraint fk_id_pac_masina foreign key (id_masina)
references MASINI(id_masina) on delete cascade;
--

--Facturi
create table
Facturi (
id_taxa number(3),
id_masina number(3),
Numar_factura number(4) constraint ver_numf not null unique,
Suma number(10,2) constraint ver_sum not null,

constraint fk_id_fact_taxa foreign key (id_taxa) references Taxe(id_taxa),
constraint fk_id_fact_masina foreign key (id_masina) references Masini(id_masina),
constraint fac_pk primary key (id_taxa, id_masina)
);

--
alter table FACTURI
drop constraint fk_id_fact_taxa;

alter table FACTURI
add constraint fk_id_fact_taxa foreign key (id_taxa)
references TAXE(id_taxa) on delete cascade;
--

--
alter table FACTURI
drop constraint fk_id_fact_masina;

alter table FACTURI
add constraint fk_id_fact_masina foreign key (id_masina)
references MASINI(id_masina) on delete cascade;
--

commit;

--Inserare date

--Cumparatori
insert into Cumparatori values(1,1,0,'Marin Catalin','MARCAT','1850824658189','VX128762',null,null,'Str. Corbului, Nr.18, Bl.L2, Sc.C','0768245399', '257000', 'macata@gmail.com', null);
insert into Cumparatori values(2,0,1,'Samsung Electronics','SamEl',null,null,'J21/228/2014','1642900012','Bulevardul Iuliu Maniu, Nr.7', '0772543995', '061113', 'samsungelectro@gmail.com','SE');
insert into Cumparatori values(3,1,0,'Ion Andrei','IA','1920315225418','VX213461',null,null,'Str. Crinului, Nr.5, Bl.C3, Sc.B','0723385699', '215332', 'ioand@gmail.com', null);
insert into Cumparatori values(4,1,0,'Costin Marian','COMA','1780412354869','VX382719',null,null,'Str. Libelulei, Nr.3, Bl.D4, Sc.A','0745221939', '332000', 'cosma@gmail.com', null);
insert into Cumparatori values(5,0,1,'ERICSSON','ERSS',null,null,'J39/121/2012','3888213511','Str. Gara Herastrau 4C, Nr.11','0725538144', '031120', 'ericcson@gmail.com', 'ER');
insert into Cumparatori values(6,1,0,'Ioana Andreea','IAND','2900223466457','CJ231548',null,null,'Str. Bucuresti, Nr.21, Bl.A1, Sc.E','0768877562', '245700', 'andrio@gmail.com', null);
insert into Cumparatori values(7,1,0,'Claudia Lavinia','CLAV','2980915056671','TM562387',null,null,'Str. Republicii, Nr.11, Bl.E7, Sc.D','0752241338', '300041', 'cllav@gmail.com', null);
insert into Cumparatori values(8,0,1,'CD PROJEKT RED','CDPR',null,null,'J15/508/2016','1391915522','Bulevardul Eroilor, Nr.5','0752247768', '200224', 'cdpred@gmail.com', 'CD');
insert into Cumparatori values(9,0,1,'Oracle Corporation','ORCP',null,null,'J22/404/2004','1552896771','Str. Independentei, Nr.12','0725567888', '072244', 'oracl@gmail.com', 'OR');
insert into Cumparatori values(10,0,1,'Spotify','SPOTI',null,null,'J33/250/2015','1982577633','Str. Aurel Vlaicu, Nr.22','0742118773', '211584', 'spotify@gmail.com', 'SP');
insert into Cumparatori values(11,1,0,'Cristina Irina','CRI','2860630253021','TM255948',null,null,'Str. Melodiilor, Nr.10, Bl.A5, Sc.C','0735512998', '300025', 'crina@gmail.com', null);
insert into Cumparatori values(12,1,0,'Bianca Malina','BIA','2920506249170','CJ778298',null,null,'Str. Fagului, Nr.15, Bl.B2, Sc.B','0722411589', '244058', 'biamal@gmail.com', null);
insert into Cumparatori values(13,1,0,'Constantin George','GEO','1910928137395','BV596327',null,null,'Str. Toporasului, Nr.7, Bl.C4, Sc.B','0768815501', '155044', 'cgeo@gmail.com', null);
insert into Cumparatori values(14,0,1,'Amazon','AMAZ',null,null,'J23/224/2014','1552345778','Bulevardul Victoriei, Nr.8','0741557768', '154003', 'amazon@gmail.com', 'AMA');
insert into Cumparatori values(15,0,1,'Youtube','YT',null,null,'J17/189/2017','1475663002','Bulevardul Muncii, Nr.19','0753324488', '045023', 'yt@gmail.com', 'YOU');

commit;

--Dotari
insert into Dotari (id_dotare,nume_dotare) values(1,'ABS');
insert into Dotari values(2,'Navigatie GPS','Da');
insert into Dotari values(3,'Senzori parcare fata-spate','Da');
insert into Dotari values(4,'Trapa','Da');
insert into Dotari (id_dotare,nume_dotare) values(5,'Airbag-uri frontale');
insert into Dotari (id_dotare,nume_dotare) values(6,'Airbag-uri laterale fata');
insert into Dotari values(7,'Pilot automat','Da');
insert into Dotari values(8,'TV','Da');
insert into Dotari values(9,'Computer de bord','Da');
insert into Dotari (id_dotare,nume_dotare) values(10,'Lumini de zi');
insert into Dotari values(11,'Camera parcare spate','Da');
insert into Dotari (id_dotare,nume_dotare) values(12,'Proiectoare ceata');
insert into Dotari (id_dotare,nume_dotare) values(13,'Servodirectie');
insert into Dotari (id_dotare,nume_dotare) values(14,'Controlul tractiunii');
insert into Dotari values(15,'Faruri Xenon','Da');
insert into Dotari (id_dotare,nume_dotare) values(16,'Suspensie reglabila');
insert into Dotari values(17,'Acoperis panoramic','Da');
insert into Dotari values(18,'Geamuri laterale spate fumurii', 'Da');
insert into Dotari values(19,'Interior din piele','Da');
insert into Dotari values(20,'Parbriz incalzit','Da');

commit;

--Taxe
insert into Taxe values(1,'Taxa de inmatriculare',1250,'E1');
insert into Taxe values(2,'Taxa poluare',1500,'E1');
insert into Taxe values(3,'Taxa oxigen',900,'E1');
insert into Taxe values(4,'Taxa motor pentru capacitate cilindrica',100,'E1');
insert into Taxe values(5,'Taxa de inmatriculare',1100,'E2');
insert into Taxe values(6,'Taxa Poluare',1300,'E2');
insert into Taxe values(7,'Taxa oxigen',800,'E2');
insert into Taxe values(8,'Taxa motor pentru capacitate cilindrica',250,'E2');
insert into Taxe values(9,'Taxa de inmatriculare',950,'E3');
insert into Taxe values(10,'Taxa Poluare',1050,'E3');
insert into Taxe values(11,'Taxa oxigen',700,'E3');
insert into Taxe values(12,'Taxa motor pentru capacitate cilindrica',400,'E3');
insert into Taxe values(13,'Taxa de inmatriculare',850,'E4');
insert into Taxe values(14,'Taxa Poluare',900,'E4');
insert into Taxe values(15,'Taxa oxigen',600,'E4');
insert into Taxe values(16,'Taxa motor pentru capacitate cilindrica',550,'E4');
insert into Taxe values(17,'Taxa de inmatriculare',700,'E5');
insert into Taxe values(18,'Taxa Poluare',650,'E5');
insert into Taxe values(19,'Taxa oxigen',500,'E5');
insert into Taxe values(20,'Taxa motor pentru capacitate cilindrica',750,'E5');
insert into Taxe values(21,'Taxa de inmatriculare',500,'E6');
insert into Taxe values(22,'Taxa Poluare',300,'E6');
insert into Taxe values(23,'Taxa oxigen',250,'E6');
insert into Taxe values(24,'Taxa motor pentru capacitate cilindrica',950,'E6');

commit;

--Furnizori
insert into Furnizori values(1,'AUDI','Calea Vitan 242', 'Bucuresti', '031301','OOAudiOO');
insert into Furnizori values(2,'BMW','Landsberger Str. 170','Munich', '80687', 'BmW');
insert into Furnizori values(3,'Nissan', 'Strada Cornu Luncii', 'Timisoara', '032108','Niss');
insert into Furnizori values(4,'Mercedes', 'Messedamm', 'Berlin', '13599', 'Merc');
insert into Furnizori values(5,'Mazda', 'S Las Vegas', 'Las Vegas', '12115', 'MZ');
insert into Furnizori values(6,'Ford', 'Piata Nicolae Balcescu 4', 'Timisoara', '300229', 'FO');
insert into Furnizori values(7,'Aston Martin', 'Calea Bucurestilor 91', 'Bucuresti', '075100', 'AM');
insert into Furnizori values(8,'Lamborghini', 'Bulevardul Pipera', 'Bucuresti', '077190', 'Lamb');
insert into Furnizori values(9,'Bugatti', '1 Arnage Blvd', 'Chesterfield', '63005', 'Bug');
insert into Furnizori values(10,'Maserati', 'Soseaua Bucuresti Nord 10', 'Bucuresti', '077190', 'Mas');
insert into Furnizori values(11,'Ferrari', 'Via del Triumvirato 84', 'Bologna', '40132', 'Ferr');
insert into Furnizori values(12,'Porsche', 'Porschepl. 9', 'Stuttgart', '70435', 'Pors');
insert into Furnizori values(13,'Jaguar', 'Lower High St', 'Watford', 'WD172J', 'Jag');
insert into Furnizori values(14,'Volkswagen', 'Lengenfelder', 'Zwickau', '08064', 'Volk');
insert into Furnizori values(15,'Lexus', '5 Chome-2-6 Tanakamachi', 'Toyama', '930985', 'Lex');

commit;

--Tari
insert into Tari values(1,'Romania');
insert into Tari values(2,'Germania');
insert into Tari values(3,'Spania');
insert into Tari values(4,'Japonia');
insert into Tari values(5,'SUA');
insert into Tari values(6,'Italia');
insert into Tari values(7,'Marea Britanie');
insert into Tari values(8,'Franta');
insert into Tari values(9,'Belgia');
insert into Tari values(10,'China');
insert into Tari values(11,'Ungaria');
insert into Tari values(12,'Polonia');
insert into Tari values(13,'Rusia');
insert into Tari values(14,'Canada');
insert into Tari values(15,'Olanda');

commit;

--Locatii
insert into Locatii values(1,'Strada Preciziei','062204', 'Bucuresti',1);
insert into Locatii values(2,'Mainzer Str.', '65189', 'Berlin', 2);
insert into Locatii values(3,'Strada Trandafirilor', '026451', 'Timisoara',1);
insert into Locatii values(4,'Avinguda Diagonal', '08028', 'Barcelona',3); 
insert into Locatii values(5,'Pearl St.', '02121', 'New York',5);
insert into Locatii values(6,'Yanagi Dori', '05022', 'Tokyo',4);
insert into Locatii values(7,'Soseaua Pantelimon', '25165', 'Bucuresti',1);
insert into Locatii values(8,'Alt-Moabit', '55312', 'Munich',2);
insert into Locatii values(9,'Viale Marco Polo', '007111', 'Roma',6);
insert into Locatii values(10,'The Mall', '322011', 'Londra',7);
insert into Locatii values(11,'Rue de Rivoli', '066789', 'Paris',8);
insert into Locatii values(12,'Cantersteen', '31522', 'Bruxelles',9);
insert into Locatii values(13,'Wenjin St.', '43155', 'Beijing',10);
insert into Locatii values(14,'Kossuth Lajos u.', '20342', 'Budapesta',11);
insert into Locatii values(15,'Solec', '89522', 'Varsovia',12);
insert into Locatii values(16,'Pyzhevskiy Pereulok', '24412', 'Moscova',13);
insert into Locatii values(17,'Albert St.', '34747', 'Ottawa',14);
insert into Locatii values(18,'Paulus Potterstraat', '22153', 'Amsterdam',15);

commit;

--Showroomuri
insert into Showroomuri (ID_SHOWROOM,DENUMIRE,CONTACT,EMAIL,IBAN,CIF,NR_REG_COM,STAMPILA,ID_LOCATIE) values(1,'DasWelt Auto','0768122334','DasWeltAuto@gmail.com','DE76RZBR9665654726635321','32384720211','J15/208/2018','DWA',2);
insert into Showroomuri (ID_SHOWROOM,DENUMIRE,CONTACT,EMAIL,IBAN,CIF,NR_REG_COM,STAMPILA,ID_LOCATIE) values(2,'Tiriac Auto','0765441678','TiriacAuto@gmail.com','RO19RZBR4431583471445917','25467898152','J13/152/2015','TA',1);
insert into Showroomuri values(3,'Dab Auto','9:30','21:30','0724551233','DabAuto@gmail.com','RO27PORL8129292474292797','33526125994','J21/55/2016','DAB',5);
insert into Showroomuri values(4,'Broker Auto','8:30','19:30','0728955133','BrokerAuto@gmail.com','RO22PORL7679675716146742','22553261128','J34/25/2017','BrA',7);
insert into Showroomuri values(5,'Auto Europa','9:30','20:00','0761152388','AutoEuropa@gmail.com','RO86PORL7514321271178279','18526625994','J85/67/2015','AE',3);
insert into Showroomuri (ID_SHOWROOM,DENUMIRE,CONTACT,EMAIL,IBAN,CIF,NR_REG_COM,STAMPILA,ID_LOCATIE) values(6,'Indus Auto BV','0723455113','IndusAuto@gmail.com','NL43INGB2596749386','19545423321','J47/223/2011','IABV',18);
insert into Showroomuri values(7,'Daihatsu Showroom','8:00','18:00','0713425589','DhShowroom@gmail.com','JP86631238795850','13442556814','J17/114/2013','DHS',6);
insert into Showroomuri (ID_SHOWROOM,DENUMIRE,CONTACT,EMAIL,IBAN,CIF,NR_REG_COM,STAMPILA,ID_LOCATIE) values(8,'SHOWROOM - DAS AUTOHAUS','0725449971','SHDASAUTO@gmail.com','DE56500105174918229472','23315889119','J12/102/2015','SDA',8);
insert into Showroomuri values(9,'Emilcar Showroom','9:00','19:00','0735783101','EmilSH@gmail.com','IT11E030203280826871526','14755236613','J35/177/2017','ESH',9);
insert into Showroomuri (ID_SHOWROOM,DENUMIRE,CONTACT,EMAIL,IBAN,CIF,NR_REG_COM,STAMPILA,ID_LOCATIE) values(10,'Autoprestige Cars','0712744885','AutoPR@gmail.com','GB30BARC20035398797257','16591122357','J10/681/2016','APC',10);
insert into Showroomuri (ID_SHOWROOM,DENUMIRE,CONTACT,EMAIL,IBAN,CIF,NR_REG_COM,STAMPILA,ID_LOCATIE) values(11,'Maserati Showroom','0721455066','MasSh@gmail.com','RO85RZBR3687819239277148','35115867193','J31/512/2014','MSH',1);
insert into Showroomuri values(12,'Showroom Occasions','8:30','18:30','0723233060','ShowOC@gmail.com','FR381756900030456288957','23351278449','J21/724/2017','SO',11);
insert into Showroomuri values(13,'Initial Auto','7:00','17:00','0732852120','IniAUTO@gmail.com','BE74519881511107','17895563210','J35/324/2012','IA',12);
insert into Showroomuri (ID_SHOWROOM,DENUMIRE,CONTACT,EMAIL,IBAN,CIF,NR_REG_COM,STAMPILA,ID_LOCATIE) values(14,'UKD AUTO','0744154031','UKDAuto@gmail.com','GB21BARC20038025298','13324665177','J77/354/2014','UKD',10);
insert into Showroomuri (ID_SHOWROOM,DENUMIRE,CONTACT,EMAIL,IBAN,CIF,NR_REG_COM,STAMPILA,ID_LOCATIE) values(15,'Renow Pacello','0739080137','RenowPac@gmail.com','IT70X0300203280745123','16325548702','J25/653/2017','REP',9);

commit;

--Dealeri
insert into Dealeri values(1,'Nicolau', 'George','0765522441','NG','georgenic@gmail.com','Str. Soseaua Pantelimon',4);
insert into Dealeri values(2,'Costea', 'Andrei','0755289911','CA','cosandr@gmail.com','Str. Preciziei',2);
insert into Dealeri values(3,'Marin', 'Ionut','0735851221','MI','marion@gmail.com','Str. Melodiilor',5);
insert into Dealeri values(4,'Ionescu', 'Marian','0788442439','IM','ionemr@gmail.com','Str. Viitorului',4);
insert into Dealeri values(5,'Oprea', 'Irina','0732884584','OI','opriri@gmail.com','Str. Polona',4);
insert into Dealeri values(6,'Dima', 'Catalin','0706496371','DC', 'dimcat@gmail.com','Tiroler Str.',8);
insert into Dealeri values(7,'Popescu', 'Andreea','0796397720','PA','popandr@gmail.com','Str. Dunarii',5);
insert into Dealeri values(8,'Stan', 'Miruna','0777747609','SM','stanmiru@gmail.com','Via Statilia',9);
insert into Dealeri values(9,'Calin', 'Stefan','0777817654','CS','calistef@gmail.com','Gold St',3);
insert into Dealeri values(10,'Joshua', 'Albert','0720916813','JA','joshalbert@gmail.com','Chapel St.',14);
insert into Dealeri values(11,'Martin', 'Josh','0792532204','MJ','martjo@gmail.com','Princess St',14);
insert into Dealeri values(12,'Armin', 'Dave','0725550697','AD','armdave@gmail.com','Great Homer St',10);
insert into Dealeri values(13,'Manuel', 'Robben','0770099353','MR','manurob@gmail.com','Bucher Str.',1);
insert into Dealeri values(14,'Fred', 'Raymond','0742529344','FR','fredray@gmail.com','Duke St',10);
insert into Dealeri values(15,'Silviu', 'Alexandru','0759202812','SA','silvale@gmail.com','Lekstraat',6);
insert into Dealeri values(16,'Stefanescu', 'Ilie','0766421782','SI','stefanilie@gmail.com','1-Chome',7);
insert into Dealeri values(17,'Tomescu', 'Teodor','0733034837','TT','dinucost@gmail.com','Str. Lalelelor',11);
insert into Dealeri values(18,'Fane', 'Cornel','0752679416','FC','fanecorn@gmail.com','Rue Monge',12);
insert into Dealeri values(19,'Sara', 'Clara','0705684618','SC','saraclr@gmail.com','Rue Melsens',13);
insert into Dealeri values(20,'Roberto', 'Hugo','0788861128','RH','robehugo@gmail.com','Via Aurelia',15);

commit;

--Masini
insert into Masini values(1,'Audi A8L','350',2020,'Benzina',700,'Euro6','Negru','Stanga','Automata','Automata',4,120000,1,1,1);
insert into Masini values(2,'BMW I8','250',2016,'Hibrid',6500,'Euro4','Alb','Dreapta','Automata','Spate',2,65000,2,2,2);
insert into Masini values(3,'BMW M7','360',2015,'Diesel',8400,'Euro4','Gri metalic','Stanga','Manuala','Fata',4,40000,3,2,3);
insert into Masini values(4,'Audi RS7','405',2017,'Diesel',3500,'Euro5','Alb','Stanga','Automata','Automata',4,60000,1,1,7);
insert into Masini values(5,'Audi A7 Sportback','370',2020,'Benzina',650,'Euro6','Negru','Stanga','Automata','Automata',4,130000,1,1,8);
insert into Masini values(6,'Mercedes GLC Coupe','207',2014,'Benzina',9500,'Euro3','Alb','Dreapta','Manuala','4x4-manual',4,45000,4,4,5);
insert into Masini values(7,'Aston Martin DB9','410',2019,'Benzina',1200,'Euro6','Bleumarin','Stanga','Automata','Automata',2,180000,10,7,4);
insert into Masini values(8,'Bugatti Veyron','500',2015,'Diesel',7600,'Euro4','Rosu','Dreapta','Manuala','Spate',2,500000,15,9,6);
insert into Masini values(9,'Mercedes CLS 63 AMG','320',2016,'Diesel',5200,'Euro4','Argintiu','Stanga','Semi-Automata','Spate',4,55000,11,4,11);
insert into Masini values(10,'Audi Q8','213',2019,'Hibrid',1000,'Euro6','Portocaliu','Dreapta','Automata','4x4-automat',4,80000,5,1,12);
insert into Masini values(11,'Bugatti Chiron','520',2017,'Diesel',2900,'Euro5','Negru','Dreapta','Semi-Automata','Fata',2,1000000,14,9,9);
insert into Masini values(12,'Ford Mustang','380',2020,'Diesel',590,'Euro6','Galben','Stanga','Semi-Automata','Fata',2,70000,1,6,13);
insert into Masini values(13,'Volkswagen Arteon','210',2018,'Electric',2250,'Euro5','Gri inchis','Dreapta','Automata','Automata',8,35000,1,14,10);
insert into Masini values(14,'Audi Q7','190',2014,'Diesel',8900,'Euro3','Verde','Stanga','Manuala','4X4-automat',4,21000,12,1,14);
insert into Masini values(15,'BMW X5','185',2013,'Benzina',10505,'Euro2','Negru','Dreapta','Manuala','4x4-manual',4,20000,6,2,16);
insert into Masini values(16,'Volkswagen Passat','150',2010,'Benzina',15000,'Euro1','Rosu','Stanga','Manuala','Fata',4,12000,7,14,19);
insert into Masini values(17,'Maserati Ghibli','320',2020,'Electric',450,'Euro6','Negru','Dreapta','Automata','Automata',4,250000,3,10,17);
insert into Masini values(18,'Lexus IS250 F Sport','275',2014,'Benzina',9200,'Euro3','Alb','Stanga','Manuala','Fata',2,37000,4,15,20);
insert into Masini values(19,'Volkswagen Passat CC','160',2015,'Diesel',8500,'Euro4','Albastru','Dreapta','Automata','Spate',4,15000,12,14,19);
insert into Masini values(20,'Lexus NX','172',2018,'Benzina',2071,'Euro5','Negru','Dreapta','Automata','4x4-automat',4,57288,2,15,20);
insert into Masini values(21,'Nissan 350Z','175',2013,'Benzina',11000,'Euro2','Portocaliu','Stanga','Manuala','Fata',2,10000,7,3,18);
insert into Masini values(22,'Lamborghini Aventador','440',2016,'Diesel',5500,'Euro4','Negru','Dreapta','Semi-Automata','Spate',2,450000,14,8,15);
insert into Masini values(23,'Mazda 6','150',2005,'Benzina',21000,'Euro1','Rosu','Stanga','Manuala','Spate',4,7000,7,5,14);
insert into Masini values(24,'Nissan Skyline GT-R R35','390',2018,'Benzina',1950,'Euro5','Albastru inchis metalic','Dreapta','Semi-Automata','Spate',2,65000,1,3,18);
insert into Masini values(25,'Jaguar XF','200',2019,'Hibrid',1453,'Euro6','Alb','Dreapta','Automata','Fata',4,87000,1,13,20);
insert into Masini values(26,'Porsche Panamera','330',2017,'Benzina',3100,'Euro5','Negru','Dreapta','Semi-Automata','Spate',4,175000,8,12,16);
insert into Masini values(27,'Ferrari F12 Berlinetta','377',2016,'Diesel',4115,'Euro4','Rosu','Dreapta','Manuala','Spate',2,255000,9,11,2);
insert into Masini values(28,'Ferrari 458 Italia','325',2014,'Benzina',9000,'Euro3','Rosu','Stanga','Manuala','Fata',2,147000,15,11,2);
insert into Masini values(29,'Lamborghini Veneno','460',2017,'Benzina',3070,'Euro5','Negru','Dreapta','Semi-Automata','Fata',2,700000,10,8,3);
insert into Masini values(30,'Porsche Cayman','349',2011,'Benzina',13500,'Euro1','Galben','Stanga','Manuala','Fata',2,28000,5,12,7);

commit;

--Pachete
insert into Pachete values(1,15,'Basic options',null);
insert into Pachete values(1,16,'Basic options',null);
insert into Pachete values(1,21,'Basic options',null);
insert into Pachete values(1,23,'Basic options',null);
insert into Pachete values(1,30,'Basic options',null);

insert into Pachete values(2,1,'Full options','Basic options');
insert into Pachete values(2,2,'Full options','Basic options');
insert into Pachete values(2,3,'Full options','Basic options');
insert into Pachete values(2,4,'Full options','Basic options');
insert into Pachete values(2,5,'Full options','Basic options');
insert into Pachete values(2,6,'Full options','Basic options');
insert into Pachete values(2,7,'Full options','Basic options');
insert into Pachete values(2,8,'Full options','Basic options');
insert into Pachete values(2,9,'Full options','Basic options');
insert into Pachete values(2,10,'Full options','Basic options');
insert into Pachete values(2,11,'Full options','Basic options');
insert into Pachete values(2,12,'Full options','Basic options');
insert into Pachete values(2,13,'Full options','Basic options');
insert into Pachete values(2,14,'Full options','Basic options');
insert into Pachete values(2,17,'Full options','Basic options');
insert into Pachete values(2,18,'Full options','Basic options');
insert into Pachete values(2,19,'Full options','Basic options');
insert into Pachete values(2,20,'Full options','Basic options');
insert into Pachete values(2,22,'Full options','Basic options');
insert into Pachete values(2,24,'Full options','Basic options');
insert into Pachete values(2,25,'Full options','Basic options');
insert into Pachete values(2,26,'Full options','Basic options');
insert into Pachete values(2,27,'Full options','Basic options');
insert into Pachete values(2,28,'Full options','Basic options');
insert into Pachete values(2,29,'Full options','Basic options');

insert into Pachete values(3,1,'Full options','Basic options');
insert into Pachete values(3,2,'Full options','Basic options');
insert into Pachete values(3,3,'Full options','Basic options');
insert into Pachete values(3,4,'Full options','Basic options');
insert into Pachete values(3,5,'Full options','Basic options');
insert into Pachete values(3,6,'Full options','Basic options');
insert into Pachete values(3,7,'Full options','Basic options');
insert into Pachete values(3,8,'Full options','Basic options');
insert into Pachete values(3,9,'Full options','Basic options');
insert into Pachete values(3,10,'Full options','Basic options');
insert into Pachete values(3,11,'Full options','Basic options');
insert into Pachete values(3,12,'Full options','Basic options');
insert into Pachete values(3,13,'Full options','Basic options');
insert into Pachete values(3,14,'Full options','Basic options');
insert into Pachete values(3,17,'Full options','Basic options');
insert into Pachete values(3,18,'Full options','Basic options');
insert into Pachete values(3,19,'Full options','Basic options');
insert into Pachete values(3,20,'Full options','Basic options');
insert into Pachete values(3,22,'Full options','Basic options');
insert into Pachete values(3,24,'Full options','Basic options');
insert into Pachete values(3,25,'Full options','Basic options');
insert into Pachete values(3,26,'Full options','Basic options');
insert into Pachete values(3,27,'Full options','Basic options');
insert into Pachete values(3,28,'Full options','Basic options');
insert into Pachete values(3,29,'Full options','Basic options');

insert into Pachete values(4,1,'Full options','Basic options');
insert into Pachete values(4,2,'Full options','Basic options');
insert into Pachete values(4,3,'Full options','Basic options');
insert into Pachete values(4,4,'Full options','Basic options');
insert into Pachete values(4,5,'Full options','Basic options');
insert into Pachete values(4,7,'Full options','Basic options');
insert into Pachete values(4,8,'Full options','Basic options');
insert into Pachete values(4,9,'Full options','Basic options');
insert into Pachete values(4,10,'Full options','Basic options');
insert into Pachete values(4,11,'Full options','Basic options');
insert into Pachete values(4,12,'Full options','Basic options');
insert into Pachete values(4,13,'Full options','Basic options');
insert into Pachete values(4,17,'Full options','Basic options');
insert into Pachete values(4,19,'Full options','Basic options');
insert into Pachete values(4,20,'Full options','Basic options');
insert into Pachete values(4,22,'Full options','Basic options');
insert into Pachete values(4,24,'Full options','Basic options');
insert into Pachete values(4,25,'Full options','Basic options');
insert into Pachete values(4,26,'Full options','Basic options');
insert into Pachete values(4,27,'Full options','Basic options');
insert into Pachete values(4,29,'Full options','Basic options');

insert into Pachete values(5,15,'Basic options',null);
insert into Pachete values(5,16,'Basic options',null);
insert into Pachete values(5,21,'Basic options',null);
insert into Pachete values(5,23,'Basic options',null);
insert into Pachete values(5,30,'Basic options',null);

insert into Pachete values(6,15,'Basic options',null);
insert into Pachete values(6,16,'Basic options',null);
insert into Pachete values(6,21,'Basic options',null);
insert into Pachete values(6,23,'Basic options',null);
insert into Pachete values(6,30,'Basic options',null);

insert into Pachete values(7,1,'Full options','Basic options');
insert into Pachete values(7,5,'Full options','Basic options');
insert into Pachete values(7,7,'Full options','Basic options');
insert into Pachete values(7,10,'Full options','Basic options');
insert into Pachete values(7,12,'Full options','Basic options');
insert into Pachete values(7,17,'Full options','Basic options');
insert into Pachete values(7,25,'Full options','Basic options');

insert into Pachete values(8,1,'Full options','Basic options');
insert into Pachete values(8,5,'Full options','Basic options');
insert into Pachete values(8,7,'Full options','Basic options');
insert into Pachete values(8,10,'Full options','Basic options');
insert into Pachete values(8,12,'Full options','Basic options');
insert into Pachete values(8,17,'Full options','Basic options');
insert into Pachete values(8,25,'Full options','Basic options');

insert into Pachete values(9,1,'Full options','Basic options');
insert into Pachete values(9,2,'Full options','Basic options');
insert into Pachete values(9,3,'Full options','Basic options');
insert into Pachete values(9,4,'Full options','Basic options');
insert into Pachete values(9,5,'Full options','Basic options');
insert into Pachete values(9,7,'Full options','Basic options');
insert into Pachete values(9,8,'Full options','Basic options');
insert into Pachete values(9,9,'Full options','Basic options');
insert into Pachete values(9,10,'Full options','Basic options');
insert into Pachete values(9,11,'Full options','Basic options');
insert into Pachete values(9,12,'Full options','Basic options');
insert into Pachete values(9,13,'Full options','Basic options');
insert into Pachete values(9,17,'Full options','Basic options');
insert into Pachete values(9,19,'Full options','Basic options');
insert into Pachete values(9,20,'Full options','Basic options');
insert into Pachete values(9,22,'Full options','Basic options');
insert into Pachete values(9,24,'Full options','Basic options');
insert into Pachete values(9,25,'Full options','Basic options');
insert into Pachete values(9,26,'Full options','Basic options');
insert into Pachete values(9,27,'Full options','Basic options');
insert into Pachete values(9,28,'Full options','Basic options');
insert into Pachete values(9,29,'Full options','Basic options');

insert into Pachete values(10,15,'Basic options',null);
insert into Pachete values(10,16,'Basic options',null);
insert into Pachete values(10,21,'Basic options',null);
insert into Pachete values(10,23,'Basic options',null);
insert into Pachete values(10,30,'Basic options',null);

insert into Pachete values(11,1,'Full options','Basic options');
insert into Pachete values(11,2,'Full options','Basic options');
insert into Pachete values(11,3,'Full options','Basic options');
insert into Pachete values(11,4,'Full options','Basic options');
insert into Pachete values(11,5,'Full options','Basic options');
insert into Pachete values(11,7,'Full options','Basic options');
insert into Pachete values(11,8,'Full options','Basic options');
insert into Pachete values(11,9,'Full options','Basic options');
insert into Pachete values(11,10,'Full options','Basic options');
insert into Pachete values(11,11,'Full options','Basic options');
insert into Pachete values(11,12,'Full options','Basic options');
insert into Pachete values(11,13,'Full options','Basic options');
insert into Pachete values(11,17,'Full options','Basic options');
insert into Pachete values(11,19,'Full options','Basic options');
insert into Pachete values(11,20,'Full options','Basic options');
insert into Pachete values(11,22,'Full options','Basic options');
insert into Pachete values(11,24,'Full options','Basic options');
insert into Pachete values(11,25,'Full options','Basic options');
insert into Pachete values(11,26,'Full options','Basic options');
insert into Pachete values(11,27,'Full options','Basic options');
insert into Pachete values(11,29,'Full options','Basic options');


insert into Pachete values(12,15,'Basic options',null);
insert into Pachete values(12,16,'Basic options',null);
insert into Pachete values(12,21,'Basic options',null);
insert into Pachete values(12,23,'Basic options',null);
insert into Pachete values(12,30,'Basic options',null);

insert into Pachete values(13,15,'Basic options',null);
insert into Pachete values(13,16,'Basic options',null);
insert into Pachete values(13,21,'Basic options',null);
insert into Pachete values(13,23,'Basic options',null);
insert into Pachete values(13,30,'Basic options',null);

insert into Pachete values(14,15,'Basic options',null);
insert into Pachete values(14,16,'Basic options',null);
insert into Pachete values(14,21,'Basic options',null);
insert into Pachete values(14,23,'Basic options',null);
insert into Pachete values(14,30,'Basic options',null);

insert into Pachete values(15,1,'Full options','Basic options');
insert into Pachete values(15,5,'Full options','Basic options');
insert into Pachete values(15,7,'Full options','Basic options');
insert into Pachete values(15,10,'Full options','Basic options');
insert into Pachete values(15,12,'Full options','Basic options');
insert into Pachete values(15,17,'Full options','Basic options');
insert into Pachete values(15,18,'Full options','Basic options');
insert into Pachete values(15,25,'Full options','Basic options');

insert into Pachete values(16,15,'Basic options',null);
insert into Pachete values(16,16,'Basic options',null);
insert into Pachete values(16,21,'Basic options',null);
insert into Pachete values(16,23,'Basic options',null);
insert into Pachete values(16,30,'Basic options',null);

insert into Pachete values(17,1,'Full options','Basic options');
insert into Pachete values(17,2,'Full options','Basic options');
insert into Pachete values(17,3,'Full options','Basic options');
insert into Pachete values(17,4,'Full options','Basic options');
insert into Pachete values(17,5,'Full options','Basic options');
insert into Pachete values(17,6,'Full options','Basic options');
insert into Pachete values(17,7,'Full options','Basic options');
insert into Pachete values(17,8,'Full options','Basic options');
insert into Pachete values(17,9,'Full options','Basic options');
insert into Pachete values(17,10,'Full options','Basic options');
insert into Pachete values(17,11,'Full options','Basic options');
insert into Pachete values(17,12,'Full options','Basic options');
insert into Pachete values(17,13,'Full options','Basic options');
insert into Pachete values(17,14,'Full options','Basic options');
insert into Pachete values(17,17,'Full options','Basic options');
insert into Pachete values(17,19,'Full options','Basic options');
insert into Pachete values(17,20,'Full options','Basic options');
insert into Pachete values(17,22,'Full options','Basic options');
insert into Pachete values(17,24,'Full options','Basic options');
insert into Pachete values(17,25,'Full options','Basic options');
insert into Pachete values(17,26,'Full options','Basic options');
insert into Pachete values(17,27,'Full options','Basic options');
insert into Pachete values(17,29,'Full options','Basic options');

insert into Pachete values(18,1,'Full options','Basic options');
insert into Pachete values(18,5,'Full options','Basic options');
insert into Pachete values(18,7,'Full options','Basic options');
insert into Pachete values(18,10,'Full options','Basic options');
insert into Pachete values(18,12,'Full options','Basic options');
insert into Pachete values(18,17,'Full options','Basic options');
insert into Pachete values(18,25,'Full options','Basic options');

insert into Pachete values(19,1,'Full options','Basic options');
insert into Pachete values(19,2,'Full options','Basic options');
insert into Pachete values(19,3,'Full options','Basic options');
insert into Pachete values(19,4,'Full options','Basic options');
insert into Pachete values(19,5,'Full options','Basic options');
insert into Pachete values(19,6,'Full options','Basic options');
insert into Pachete values(19,7,'Full options','Basic options');
insert into Pachete values(19,8,'Full options','Basic options');
insert into Pachete values(19,9,'Full options','Basic options');
insert into Pachete values(19,10,'Full options','Basic options');
insert into Pachete values(19,11,'Full options','Basic options');
insert into Pachete values(19,12,'Full options','Basic options');
insert into Pachete values(19,13,'Full options','Basic options');
insert into Pachete values(19,14,'Full options','Basic options');
insert into Pachete values(19,17,'Full options','Basic options');
insert into Pachete values(19,18,'Full options','Basic options');
insert into Pachete values(19,19,'Full options','Basic options');
insert into Pachete values(19,20,'Full options','Basic options');
insert into Pachete values(19,22,'Full options','Basic options');
insert into Pachete values(19,24,'Full options','Basic options');
insert into Pachete values(19,25,'Full options','Basic options');
insert into Pachete values(19,26,'Full options','Basic options');
insert into Pachete values(19,27,'Full options','Basic options');
insert into Pachete values(19,28,'Full options','Basic options');
insert into Pachete values(19,29,'Full options','Basic options');

insert into Pachete values(20,1,'Full options','Basic options');
insert into Pachete values(20,2,'Full options','Basic options');
insert into Pachete values(20,3,'Full options','Basic options');
insert into Pachete values(20,4,'Full options','Basic options');
insert into Pachete values(20,5,'Full options','Basic options');
insert into Pachete values(20,7,'Full options','Basic options');
insert into Pachete values(20,8,'Full options','Basic options');
insert into Pachete values(20,9,'Full options','Basic options');
insert into Pachete values(20,10,'Full options','Basic options');
insert into Pachete values(20,11,'Full options','Basic options');
insert into Pachete values(20,12,'Full options','Basic options');
insert into Pachete values(20,13,'Full options','Basic options');
insert into Pachete values(20,17,'Full options','Basic options');
insert into Pachete values(20,19,'Full options','Basic options');
insert into Pachete values(20,20,'Full options','Basic options');
insert into Pachete values(20,22,'Full options','Basic options');
insert into Pachete values(20,24,'Full options','Basic options');
insert into Pachete values(20,25,'Full options','Basic options');
insert into Pachete values(20,26,'Full options','Basic options');
insert into Pachete values(20,27,'Full options','Basic options');
insert into Pachete values(20,29,'Full options','Basic options');

commit;

--Facturi
--E1
insert into Facturi values(1,16,1,1250);
insert into Facturi values(1,23,2,1250);
insert into Facturi values(1,30,3,1250);

insert into Facturi values(2,16,4,1500);
insert into Facturi values(2,23,5,1500);
insert into Facturi values(2,30,6,1500);

insert into Facturi values(3,16,7,900);
insert into Facturi values(3,23,8,900);
insert into Facturi values(3,30,9,900);

insert into Facturi values(4,16,10,100);
insert into Facturi values(4,23,11,100);
insert into Facturi values(4,30,12,100);

--E2
insert into Facturi values(5,15,13,1100);
insert into Facturi values(5,21,14,1100);

insert into Facturi values(6,15,15,1300);
insert into Facturi values(6,21,16,1300);

insert into Facturi values(7,15,17,800);
insert into Facturi values(7,21,18,800);

insert into Facturi values(8,15,19,250);
insert into Facturi values(8,21,20,250);

--E3
insert into Facturi values(9,6,21,950);
insert into Facturi values(9,14,22,950);
insert into Facturi values(9,18,23,950);
insert into Facturi values(9,28,24,950);

insert into Facturi values(10,6,25,1050);
insert into Facturi values(10,14,26,1050);
insert into Facturi values(10,18,27,1050);
insert into Facturi values(10,28,28,1050);

insert into Facturi values(11,6,29,700);
insert into Facturi values(11,14,30,700);
insert into Facturi values(11,18,31,700);
insert into Facturi values(11,28,32,700);

insert into Facturi values(12,6,33,400);
insert into Facturi values(12,14,34,400);
insert into Facturi values(12,18,35,400);
insert into Facturi values(12,28,36,400);

--E4
insert into Facturi values(13,2,37,850);
insert into Facturi values(13,3,38,850);
insert into Facturi values(13,8,39,850);
insert into Facturi values(13,9,40,850);
insert into Facturi values(13,19,41,850);
insert into Facturi values(13,22,42,850);
insert into Facturi values(13,27,43,850);

insert into Facturi values(14,2,44,900);
insert into Facturi values(14,3,45,900);
insert into Facturi values(14,8,46,900);
insert into Facturi values(14,9,47,900);
insert into Facturi values(14,19,48,900);
insert into Facturi values(14,22,49,900);
insert into Facturi values(14,27,50,900);

insert into Facturi values(15,2,51,600);
insert into Facturi values(15,3,52,600);
insert into Facturi values(15,8,53,600);
insert into Facturi values(15,9,54,600);
insert into Facturi values(15,19,55,600);
insert into Facturi values(15,22,56,600);
insert into Facturi values(15,27,57,600);

insert into Facturi values(16,2,58,550);
insert into Facturi values(16,3,59,550);
insert into Facturi values(16,8,60,550);
insert into Facturi values(16,9,61,550);
insert into Facturi values(16,19,62,550);
insert into Facturi values(16,22,63,550);
insert into Facturi values(16,27,64,550);

--E5
insert into Facturi values(17,4,65,700);
insert into Facturi values(17,11,66,700);
insert into Facturi values(17,13,67,700);
insert into Facturi values(17,20,68,700);
insert into Facturi values(17,24,69,700);
insert into Facturi values(17,26,70,700);
insert into Facturi values(17,29,71,700);

insert into Facturi values(18,4,72,650);
insert into Facturi values(18,11,73,650);
insert into Facturi values(18,13,74,650);
insert into Facturi values(18,20,75,650);
insert into Facturi values(18,24,76,650);
insert into Facturi values(18,26,77,650);
insert into Facturi values(18,29,78,650);

insert into Facturi values(19,4,79,500);
insert into Facturi values(19,11,80,500);
insert into Facturi values(19,13,81,500);
insert into Facturi values(19,20,82,500);
insert into Facturi values(19,24,83,500);
insert into Facturi values(19,26,84,500);
insert into Facturi values(19,29,85,500);

insert into Facturi values(20,4,86,750);
insert into Facturi values(20,11,87,750);
insert into Facturi values(20,13,88,750);
insert into Facturi values(20,20,89,750);
insert into Facturi values(20,24,90,750);
insert into Facturi values(20,26,91,750);
insert into Facturi values(20,29,92,750);

--E6
insert into Facturi values(21,1,93,500);
insert into Facturi values(21,5,94,500);
insert into Facturi values(21,7,95,500);
insert into Facturi values(21,10,96,500);
insert into Facturi values(21,12,97,500);
insert into Facturi values(21,17,98,500);
insert into Facturi values(21,25,99,500);

insert into Facturi values(22,1,100,300);
insert into Facturi values(22,5,101,300);
insert into Facturi values(22,7,102,300);
insert into Facturi values(22,10,103,300);
insert into Facturi values(22,12,104,300);
insert into Facturi values(22,17,105,300);
insert into Facturi values(22,25,106,300);

insert into Facturi values(23,1,107,250);
insert into Facturi values(23,5,108,250);
insert into Facturi values(23,7,109,250);
insert into Facturi values(23,10,110,250);
insert into Facturi values(23,12,111,250);
insert into Facturi values(23,17,112,250);
insert into Facturi values(23,25,113,250);

insert into Facturi values(24,1,114,950);
insert into Facturi values(24,5,115,950);
insert into Facturi values(24,7,116,950);
insert into Facturi values(24,10,117,950);
insert into Facturi values(24,12,118,950);
insert into Facturi values(24,17,119,950);
insert into Facturi values(24,25,120,950);

commit;

--Vizualizari
--1
CREATE OR REPLACE NOFORCE view Masini_2015 
AS 
SELECT id_masina, model_masina, an_fabricatie, dealeri.id_dealer, nume, prenume, showroomuri.id_showroom, denumire, ora_deschidere, ora_inchidere, oras
from masini join dealeri on (masini.id_dealer = dealeri.id_dealer) 
join showroomuri on (dealeri.id_showroom = showroomuri.id_showroom)
join locatii on (showroomuri.id_locatie = locatii.id_locatie)
where an_fabricatie > 2015 and ora_inchidere > '19:00' and oras in ('Bucuresti','Londra','Roma');

--in cazul in care am fi realizat ca exemplu pentru operatia LMD un insert atunci trebuia sa introducem toate coloanele not null;
--CREATE OR REPLACE NOFORCE view Masini_2015 
--AS 
--SELECT id_masina, model_masina, cai_putere, an_fabricatie, combustibil, kilometraj, norma_poluare, culoare, tip_volan, cutie_viteze, transmisie, numar_portiere, pret,
--dealeri.id_dealer, nume, prenume, telefon, semnatura, domiciliu,
--showroomuri.id_showroom, denumire, ora_deschidere, ora_inchidere, contact, email, iban, cif, nr_reg_com, stampila,
--locatii.id_locatie, adresa, cod_postal,oras 
--from masini join dealeri on (masini.id_dealer = dealeri.id_dealer) 
--join showroomuri on (dealeri.id_showroom = showroomuri.id_showroom)
--join locatii on (showroomuri.id_locatie = locatii.id_locatie)
--where an_fabricatie > 2015 and ora_inchidere > '19:00' and oras in ('Bucuresti','Londra','Roma');

--2
CREATE OR REPLACE NOFORCE view Furnizori_masini2 
AS
select denumire, count(id_masina) "Numar_masini", avg(pret) "Media_preturilor", avg(kilometraj) "Media_kilometrilor"
from masini join furnizori on (masini.id_furnizor = furnizori.id_furnizor)
group by denumire
having count(id_masina) >= 2 and avg(pret) > 25000 and avg(kilometraj) < 8400;

commit;
--with read only;