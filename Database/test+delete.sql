--Delete test
delete from tari
where id_tara = 1;

delete from cumparatori
where id_cumparator = 1;

delete from furnizori
where id_furnizor = 2;

delete from taxe
where id_taxa = 21;

delete from dotari
where id_dotare = 2;

delete from dealeri
where id_dealer = 14;

commit;

--Delete tabele

--Drop in caz de probleme
drop table facturi;
drop table taxe;
drop table pachete;
drop table dotari;
drop table masini;
drop table furnizori;
drop table dealeri;
drop table showroomuri;
drop table locatii;
drop table tari;
drop table cumparatori;

commit;

drop view Vizualizare1;
drop view Vizualizare2;

commit;
