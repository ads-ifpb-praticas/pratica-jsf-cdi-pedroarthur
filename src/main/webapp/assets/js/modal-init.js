/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function() {
   $('#modalMsg').modal('show');
   
   $('.selectable-table > tbody > tr').click(function() {
       $(this).toggleClass('info').siblings().removeClass('info');
   });
});
