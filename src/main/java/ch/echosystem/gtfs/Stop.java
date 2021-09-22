package ch.echosystem.gtfs;

public final class Stop extends Name
	{
	public enum Type
		{
		}

	private Type type;
	
	public Type getType()
		{
		return type;
		}
	
	public void setType(final Type type)
		{
		this.type = type;
		}
	}

/*
stop_id 	ID 	Obligatoire 	Identifie un arrêt, une station ou une entrée de station.

Le terme "entrée de station" désigne à la fois les entrées et les sorties de station. Les arrêts, les stations et les entrées de station sont collectivement appelés "emplacements". Le même arrêt peut être desservi par plusieurs itinéraires.
stop_code 	Texte 	Facultatif 	Texte court ou numéro identifiant l'emplacement pour les usagers. Ces codes sont souvent utilisés dans les systèmes d'information par téléphone sur les transports en commun ou imprimés sur les panneaux, afin de fournir aux usagers des informations sur un emplacement en particulier. La valeur de stop_code peut être identique à celle de stop_id si elle est destinée à être vue par les usagers. Laissez ce champ vide pour les emplacements dont le code n'est pas présenté aux usagers.
stop_name 	Texte 	Obligatoire sous certaines conditions 	Nom de l'emplacement. Utilisez un nom compréhensible à la fois pour les habitants de la région et pour les touristes.

Lorsque l'emplacement est une zone d'embarquement (avec la valeur location_type=4), incluez le nom de la zone (tel qu'il est indiqué par l'agence) dans le champ stop_name. Il peut s'agir simplement d'une lettre (comme dans certaines gares européennes) ou d'un texte de type "zone d'accès aménagée pour les fauteuils roulants" (comme dans le métro de New York) ou "accès aux voitures avant" (RER de Paris).

Obligatoire sous certaines conditions :
• Ce champ est obligatoire pour les emplacements qui sont des arrêts (location_type=0), des stations (location_type=1) ou des entrées/sorties (location_type=2).
• Il est facultatif pour les emplacements qui sont des intersections génériques (location_type=3) ou des zones d'embarquement (location_type=4).
stop_desc 	Texte 	Facultatif 	Description de l'emplacement. Les informations fournies doivent être utiles et de qualité. Ne vous contentez pas de répéter le nom de l'emplacement.
stop_lat 	Latitude 	Obligatoire sous certaines conditions 	Latitude de l'emplacement.

Obligatoire sous certaines conditions :
• Ce champ est obligatoire pour les emplacements qui sont des arrêts (location_type=0), des stations (location_type=1) ou des entrées/sorties (location_type=2).
• Il est facultatif pour les emplacements qui sont des intersections génériques (location_type=3) ou des zones d'embarquement (location_type=4).
stop_lon 	Longitude 	Obligatoire sous certaines conditions 	Longitude de l'emplacement.

Obligatoire sous certaines conditions :
• Ce champ est obligatoire pour les emplacements qui sont des arrêts (location_type=0), des stations (location_type=1) ou des entrées/sorties (location_type=2).
• Il est facultatif pour les emplacements qui sont des intersections génériques (location_type=3) ou des zones d'embarquement (location_type=4).
zone_id 	ID 	Obligatoire sous certaines conditions 	Définit la zone tarifaire d'un arrêt. Ce champ est obligatoire si vous souhaitez fournir des informations tarifaires dans un fichier fare_rules.txt. Autrement, il est facultatif. Si l'enregistrement représente une station ou une entrée de station, le champ zone_id est ignoré.
stop_url 	URL 	Facultatif 	URL d'une page Web qui décrit l'emplacement. Cette URL doit être différente de celles indiquées dans les champs agency.agency_url et routes.route_url.
location_type 	Énumération 	Facultatif 	Type d'emplacement :
• 0 ou vide : arrêt ou quai (lieu où les usagers montent dans un véhicule de transport en commun ou en descendent). Le terme "quai" est utilisé lorsque cette valeur est définie au sein d'un champ parent_station.
• 1 : station (zone ou structure physique comprenant un ou plusieurs quais)
• 2 : entrée ou sortie (lieu où les usagers peuvent entrer dans une station depuis la rue ou en sortir). Si une entrée/sortie appartient à plusieurs stations, tous les chemins correspondants sont indiqués, et le fournisseur de données doit désigner une station en tant que station principale (parente).
• 3 : intersection générique (un emplacement dans une station qui ne correspond à aucune autre valeur location_type). Les intersections génériques permettent de relier les chemins définis dans le fichier pathways.txt.
• 4 : Zone d'embarquement (un emplacement spécifique sur un quai où les usagers peuvent monter à bord d'un véhicule ou en descendre).
parent_station 	ID qui fait référence à stops.stop_id 	Obligatoire sous certaines conditions 	Spécifie la hiérarchie entre les différents emplacements définis dans le fichier stops.txt. Contient l'ID de l'emplacement parent, comme suit :
• Arrêt/quai (location_type=0) : le champ parent_station contient l'ID d'une station.
• Station (location_type=1) : ce champ doit être vide.
• Entrée/sortie (location_type=2) ou intersection générique (location_type=3) : le champ parent_station contient l'ID d'une station (location_type=1).
• zone d'embarquement (location_type=4) : le champ parent_station contient l'ID d'un quai.

Obligatoire sous certaines conditions :
• Ce champ est obligatoire pour les emplacements qui sont des entrées (location_type=2), des intersections génériques (location_type=3) ou des zones d'embarquement (location_type=4).
• Il est facultatif pour les arrêts/quais (location_type=0).
• Il est interdit pour les stations (location_type=1).
stop_timezone 	Fuseau horaire 	Facultatif 	Fuseau horaire de l'emplacement. Si l'emplacement a une station parente, il hérite du fuseau horaire de cette dernière plutôt que d'utiliser la sienne. Les stations et les arrêts sans parents dont la valeur stop_timezone est vide héritent du fuseau horaire spécifié par agency.agency_timezone. Si des valeurs stop_timezone sont fournies, les heures incluses dans le fichier stop_times.txt doivent toujours être indiquées en tant qu'heures depuis minuit dans le fuseau horaire spécifié par le champ agency.agency_timezone. Cela garantit que les valeurs temporelles d'un trajet augmentent toujours au cours de celui-ci, quels que soient les fuseaux horaires traversés.
wheelchair_boarding 	Énumération 	Facultatif 	Indique si l'emplacement est aménagé pour les usagers en fauteuil roulant. Les options suivantes sont acceptées :

Pour les arrêts sans parents :
0 ou vide : aucune information n'est disponible concernant l'accessibilité de l'arrêt.
1 : certains véhicules à cet arrêt peuvent accueillir un usager en fauteuil roulant.
2 : les usagers en fauteuil roulant ne peuvent pas monter à bord des véhicules à cet arrêt.

Pour un arrêt qui fait partie d'une station :
0 ou vide : l'arrêt hérite du comportement wheelchair_boarding de la station parente, s'il est renseigné.
1 : des voies permettent d'accéder en fauteuil roulant à l'arrêt ou au quai en question depuis l'extérieur de la station.
2 : aucune voie ne permet d'accéder en fauteuil roulant à l'arrêt ou au quai en question depuis l'extérieur de la station.

Pour les entrées/sorties de station :
0 ou vide : l'entrée de la station hérite du comportement wheelchair_boarding de la station principale, s'il est renseigné.
1 : l'entrée de la station est accessible en fauteuil roulant.
2 : aucune voie accessible en fauteuil roulant ne relie l'entrée de la station aux arrêts/quais.
level_id 	ID qui fait référence à levels.level_id 	Facultatif 	Étage auquel l'emplacement se trouve. Un même étage peut être spécifié pour plusieurs stations distinctes.
platform_code 	Texte 	Facultatif 	Identifiant de quai pour un arrêt de type quai (lorsque l'arrêt se trouve dans une station). Il ne doit s'agir que de l'identifiant de la plateforme (par exemple, G ou 3). N'ajoutez pas de mots comme "quai" ou "voie", ou l'équivalent dans la langue du flux. Les utilisateurs du flux peuvent ainsi internationaliser plus facilement l'identifiant du quai et le localiser dans d'autres langues.
*/