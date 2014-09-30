# This is script that pulls the Quandl stock prices from Quandl.
# It then prints the data to the screen in JSON format.
# It prepends the JSON with Quandl metadata (code, description)

require 'csv'
require 'json'
require 'open-uri'
require 'net/http'

fJson = File.open("jsonDB.json",'w')
tickers = Array.new
type = 'WIKI'

CSV.foreach("quandl.csv") do |row|  #open your file and loop through the rows
	tickers.push(row[0])
end

tickers.each do |ticker|
	
	url = ("https://www.quandl.com/api/v1/datasets/#{type}/#{ticker}.json?column=4&sort_order=asc&collapse=daily&auth_token=yyUqjmtLNag5dmxU8xkG&output=json")

	# Parse the url to check its components whether it exists at all
	url_parse = URI.parse(url)
	req = Net::HTTP.new(url_parse.host, url_parse.port)
	req.use_ssl = true
	res = req.request_head(url)
	puts ticker + ": " + res.code
	#puts url_parse.host
	
	if res.code == "200"
		fJson.write(open(url).readlines)
		fJson.write("\n")
		puts "Page successfully processed."
	elsif res.code == "403"
		puts "Forbidden: Page probably requires special permission."
	elsif res.code == "404"
		puts "Page cannot be reached."
    elsif res.code == "429"
		puts "Too many requests. Please try again later."
	end
end

fJson.close


