select p.id, p.achternaam, p.geboortedatum, p.roepnaam, p.voorletters, d.deelnemernummer, d.registratiedatum, v.volgnummer, v.bladnummer, o.code, o.naam from persoon p
left outer join deelnemer d on p.id = d.persoon
left outer join verbintenis v on v.deelnemer = d.id
left outer join opleiding o on o.id = v.opleiding
order by p.id;

select p.id, p.achternaam, p.geboortedatum, p.roepnaam, p.voorletters, d.deelnemernummer, d.registratiedatum, gd.id as groepsdeelname, gd.begindatum, gd.einddatum, v.volgnummer, v.bladnummer, o.code as opleiding, o.naam, g.id as groep, g.code, g.naam from groep g
join groepsdeelname gd on gd.groep = g.id
join deelnemer d on gd.deelnemer = d.id
join persoon p on d.persoon = p.id
join verbintenis v on v.deelnemer = d.id
left outer join opleiding o on v.opleiding = o.id
order by p.id, gd.id, v.volgnummer, v.bladnummer;

select o.id, o.code, o.naam from opleiding o;

select g.id, g.code, g.naam from groep g;