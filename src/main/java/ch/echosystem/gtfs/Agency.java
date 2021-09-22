package ch.echosystem.gtfs;

import java.util.TimeZone;

public final class Agency extends Name
	{
	private String url;
	private TimeZone timezone;

	public String getUrl()
		{
		return url;
		}
	
	public void setUrl(final String url)
		{
		this.url = url;
		}
	
	public TimeZone getTimeZone()
		{
		return timezone;
		}
	
	public void setTimeZone(final TimeZone timezone)
		{
		this.timezone = timezone;
		}
	}
/*
agency_id 	ID 	Obligatoire sous certaines conditions 	Indique la marque du réseau de transports en commun (souvent identique au nom de l'agence). Notez que dans certains cas, par exemple lorsqu'une agence gère plusieurs services, les noms de marques sont distincts de ceux des agences. Dans ce document, nous utilisons le terme "agence" pour faire référence à la marque. Un ensemble de données peut inclure des données provenant de plusieurs agences. Ce champ est obligatoire pour les ensembles de données qui contiennent les données de plusieurs agences. Dans les autres cas, il est facultatif.
agency_name 	Texte 	Obligatoire 	Nom complet de l'agence de transports en commun.
agency_url 	URL 	Obligatoire 	URL de l'agence de transports en commun.
agency_timezone 	Fuseau horaire 	Obligatoire 	Fuseau horaire de la zone où se trouve l'agence de transports en commun. Si plusieurs agences sont spécifiées dans l'ensemble de données, le champ agency_timezone doit être le même pour chacune d'entre elles.
agency_lang 	Code de langue 	Facultatif 	Langue principale utilisée par cette agence de transports en commun. Ce champ aide les utilisateurs GTFS à définir les règles concernant l'emploi des majuscules et d'autres paramètres spécifiques à la langue pour l'ensemble de données.
agency_phone 	Numéro de téléphone 	Facultatif 	Numéro de téléphone de l'agence spécifiée. Ce champ est une valeur de chaîne qui indique le numéro de téléphone habituel pour la zone desservie par l'agence. Il est censé contenir des signes de ponctuation permettant de regrouper les chiffres du numéro. Le texte convertible en numéro de téléphone (par exemple, le numéro 503-238-RIDE de TriMet) est autorisé, à condition que le champ ne contienne aucun autre texte descriptif.
agency_fare_url 	URL 	Facultatif 	URL d'une page Web qui permet à un usager d'acheter des tickets ou d'autres titres de transport en ligne auprès de cette agence.
agency_email 	Adresse e-mail 	Facultatif 	Adresse e-mail consultée régulièrement par le service client de l'agence. Cette adresse e-mail doit constituer un point de contact via lequel les usagers des transports en commun peuvent contacter un conseiller clientèle de l'agence.
*/