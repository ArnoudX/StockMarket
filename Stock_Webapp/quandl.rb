# This is script that pulls the Quandl stock prices from Quandl.
# It then prints the data to the screen in JSON format.
# It prepends the JSON with Quandl metadata (code, description)

require 'csv'
require 'open-uri'

i = 1
num = 242
quandl = File.open("quandl.csv",'w')

while i <= num  do
	url = ("http://www.quandl.com/api/v2/datasets.csv?query=*&source_code=GOOG&per_page=300&page=#{i}&auth_token=yyUqjmtLNag5dmxU8xkG")
	quandl.write(open(url).read())
	puts "Page #{i} successfully processed."
	i=i+1
end

quandl.close
