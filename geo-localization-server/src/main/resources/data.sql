DROP TABLE IF EXISTS localizations;

CREATE TABLE localizations (
id LONG AUTO_INCREMENT PRIMARY KEY,
latitude VARCHAR(250) NOT NULL,
longitude VARCHAR(250) NOT NULL,
date_created TIMESTAMP NOT NULL
);

INSERT INTO localizations (id,latitude, longitude, date_created) VALUES
(1, '52.229675', '21.012230', '2008-01-01 00:00:01'),
(2, '50.370949', '17.259890', '2018-01-01 00:00:01'),
(3, '47.751076', '-120.740135', '2008-02-01 00:00:01'),
(4, '28.704060', '77.102493', '2008-03-01 00:00:01');
