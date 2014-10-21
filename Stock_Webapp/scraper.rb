# This is script that pulls the Quandl stock prices from Quandl.
# It then prints the data to the screen in JSON format.
# It prepends the JSON with Quandl metadata (code, description)

require 'csv'
require 'json'
require 'open-uri'
require 'net/http'

tickers = Array.new
number = 0

CSV.foreach("quandl.csv") do |row|  #open your file and loop through the rows
	if number >= 67861
		tickers.push(row[0])
	end
	number = number + 1
end

number = 67861
errors = File.open("errors#{number}.csv",'w')

tickers.each do |ticker|
	url = ("http://www.quandl.com/api/v1/datasets/#{ticker}.json?trim_start=1950-12-12&trim_end=2014-10-07&auth_token=yyUqjmtLNag5dmxU8xkG")

	# Parse the url to check its components whether it exists at all
	url_parse = URI.parse(url)
	req = Net::HTTP.new(url_parse.host, url_parse.port)
	req.use_ssl = false
	res = req.request_head(url)
	#puts ticker + ": " + res.code
	#puts url_parse.host
	
	if res.code == "200"
		fJson = File.open("#{number}.json",'w')
		fJson.write(open(url).read())
		fJson.close
		puts "Page #{number} successfully processed."
	elsif res.code == "403"
		puts "Forbidden: Page #{number} probably requires special permission."
	elsif res.code == "404"
		puts "Page #{number} cannot be reached."
    elsif res.code == "429"
		puts "Too many requests. Please try again later."
	elsif res.code == "500"
		errors.write("#{ticker}")
		errors.write("#{number}")
		puts "Internal Server error on page #{number}."
	end
	number = number + 1
end

errors.close


