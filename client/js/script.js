function SubForm (){
  $.ajax({
      url:'https://api.apispreadsheets.com/data/4146/',
      type:'post',
      data:$("#sign-up-form").serializeArray(),
      success: function(){
        alert("Added to the list :)")
      },
      error: function(){
        alert("There was an error :(")
      }
  });
}