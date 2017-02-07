package org.xtext.example.mydsl.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.xtext.example.mydsl.services.VideoGenGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalVideoGenParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_LEFT_BRACKET", "RULE_RIGHT_BRACKET", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'VideoGen'", "'@author'", "'@version'", "'@creation'", "'mandatory'", "'optional'", "'alternatives'", "'videoseq'", "'duration'", "'probability'", "'textIncrust'", "'size'", "'description'", "'subtitle'", "'text'", "'filter'", "'color'", "'content'", "'position'", "'TOP'", "'BOTTOM'", "'CENTER'", "'b&w'", "'negate'", "'flip'", "'h'", "'horizontal'", "'v'", "'vertical'"
    };
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=10;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__37=37;
    public static final int RULE_RIGHT_BRACKET=5;
    public static final int T__16=16;
    public static final int T__38=38;
    public static final int T__17=17;
    public static final int T__39=39;
    public static final int T__18=18;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__13=13;
    public static final int T__35=35;
    public static final int T__14=14;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_ID=7;
    public static final int RULE_WS=11;
    public static final int RULE_LEFT_BRACKET=4;
    public static final int RULE_ANY_OTHER=12;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=8;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalVideoGenParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalVideoGenParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalVideoGenParser.tokenNames; }
    public String getGrammarFileName() { return "InternalVideoGen.g"; }



     	private VideoGenGrammarAccess grammarAccess;
     	
        public InternalVideoGenParser(TokenStream input, VideoGenGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "VideoGeneratorModel";	
       	}
       	
       	@Override
       	protected VideoGenGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleVideoGeneratorModel"
    // InternalVideoGen.g:67:1: entryRuleVideoGeneratorModel returns [EObject current=null] : iv_ruleVideoGeneratorModel= ruleVideoGeneratorModel EOF ;
    public final EObject entryRuleVideoGeneratorModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVideoGeneratorModel = null;


        try {
            // InternalVideoGen.g:68:2: (iv_ruleVideoGeneratorModel= ruleVideoGeneratorModel EOF )
            // InternalVideoGen.g:69:2: iv_ruleVideoGeneratorModel= ruleVideoGeneratorModel EOF
            {
             newCompositeNode(grammarAccess.getVideoGeneratorModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVideoGeneratorModel=ruleVideoGeneratorModel();

            state._fsp--;

             current =iv_ruleVideoGeneratorModel; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVideoGeneratorModel"


    // $ANTLR start "ruleVideoGeneratorModel"
    // InternalVideoGen.g:76:1: ruleVideoGeneratorModel returns [EObject current=null] : ( () ( (lv_information_1_0= ruleVideoGenInformation ) )? otherlv_2= 'VideoGen' this_LEFT_BRACKET_3= RULE_LEFT_BRACKET ( (lv_videoseqs_4_0= ruleVideoSeq ) )+ this_RIGHT_BRACKET_5= RULE_RIGHT_BRACKET ) ;
    public final EObject ruleVideoGeneratorModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token this_LEFT_BRACKET_3=null;
        Token this_RIGHT_BRACKET_5=null;
        EObject lv_information_1_0 = null;

        EObject lv_videoseqs_4_0 = null;


         enterRule(); 
            
        try {
            // InternalVideoGen.g:79:28: ( ( () ( (lv_information_1_0= ruleVideoGenInformation ) )? otherlv_2= 'VideoGen' this_LEFT_BRACKET_3= RULE_LEFT_BRACKET ( (lv_videoseqs_4_0= ruleVideoSeq ) )+ this_RIGHT_BRACKET_5= RULE_RIGHT_BRACKET ) )
            // InternalVideoGen.g:80:1: ( () ( (lv_information_1_0= ruleVideoGenInformation ) )? otherlv_2= 'VideoGen' this_LEFT_BRACKET_3= RULE_LEFT_BRACKET ( (lv_videoseqs_4_0= ruleVideoSeq ) )+ this_RIGHT_BRACKET_5= RULE_RIGHT_BRACKET )
            {
            // InternalVideoGen.g:80:1: ( () ( (lv_information_1_0= ruleVideoGenInformation ) )? otherlv_2= 'VideoGen' this_LEFT_BRACKET_3= RULE_LEFT_BRACKET ( (lv_videoseqs_4_0= ruleVideoSeq ) )+ this_RIGHT_BRACKET_5= RULE_RIGHT_BRACKET )
            // InternalVideoGen.g:80:2: () ( (lv_information_1_0= ruleVideoGenInformation ) )? otherlv_2= 'VideoGen' this_LEFT_BRACKET_3= RULE_LEFT_BRACKET ( (lv_videoseqs_4_0= ruleVideoSeq ) )+ this_RIGHT_BRACKET_5= RULE_RIGHT_BRACKET
            {
            // InternalVideoGen.g:80:2: ()
            // InternalVideoGen.g:81:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getVideoGeneratorModelAccess().getVideoGeneratorModelAction_0(),
                        current);
                

            }

            // InternalVideoGen.g:86:2: ( (lv_information_1_0= ruleVideoGenInformation ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==14) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalVideoGen.g:87:1: (lv_information_1_0= ruleVideoGenInformation )
                    {
                    // InternalVideoGen.g:87:1: (lv_information_1_0= ruleVideoGenInformation )
                    // InternalVideoGen.g:88:3: lv_information_1_0= ruleVideoGenInformation
                    {
                     
                    	        newCompositeNode(grammarAccess.getVideoGeneratorModelAccess().getInformationVideoGenInformationParserRuleCall_1_0()); 
                    	    
                    pushFollow(FOLLOW_3);
                    lv_information_1_0=ruleVideoGenInformation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getVideoGeneratorModelRule());
                    	        }
                           		set(
                           			current, 
                           			"information",
                            		lv_information_1_0, 
                            		"org.xtext.example.mydsl.VideoGen.VideoGenInformation");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,13,FOLLOW_4); 

                	newLeafNode(otherlv_2, grammarAccess.getVideoGeneratorModelAccess().getVideoGenKeyword_2());
                
            this_LEFT_BRACKET_3=(Token)match(input,RULE_LEFT_BRACKET,FOLLOW_5); 
             
                newLeafNode(this_LEFT_BRACKET_3, grammarAccess.getVideoGeneratorModelAccess().getLEFT_BRACKETTerminalRuleCall_3()); 
                
            // InternalVideoGen.g:112:1: ( (lv_videoseqs_4_0= ruleVideoSeq ) )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=17 && LA2_0<=19)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalVideoGen.g:113:1: (lv_videoseqs_4_0= ruleVideoSeq )
            	    {
            	    // InternalVideoGen.g:113:1: (lv_videoseqs_4_0= ruleVideoSeq )
            	    // InternalVideoGen.g:114:3: lv_videoseqs_4_0= ruleVideoSeq
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getVideoGeneratorModelAccess().getVideoseqsVideoSeqParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_6);
            	    lv_videoseqs_4_0=ruleVideoSeq();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getVideoGeneratorModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"videoseqs",
            	            		lv_videoseqs_4_0, 
            	            		"org.xtext.example.mydsl.VideoGen.VideoSeq");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);

            this_RIGHT_BRACKET_5=(Token)match(input,RULE_RIGHT_BRACKET,FOLLOW_2); 
             
                newLeafNode(this_RIGHT_BRACKET_5, grammarAccess.getVideoGeneratorModelAccess().getRIGHT_BRACKETTerminalRuleCall_5()); 
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVideoGeneratorModel"


    // $ANTLR start "entryRuleVideoGenInformation"
    // InternalVideoGen.g:142:1: entryRuleVideoGenInformation returns [EObject current=null] : iv_ruleVideoGenInformation= ruleVideoGenInformation EOF ;
    public final EObject entryRuleVideoGenInformation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVideoGenInformation = null;


        try {
            // InternalVideoGen.g:143:2: (iv_ruleVideoGenInformation= ruleVideoGenInformation EOF )
            // InternalVideoGen.g:144:2: iv_ruleVideoGenInformation= ruleVideoGenInformation EOF
            {
             newCompositeNode(grammarAccess.getVideoGenInformationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVideoGenInformation=ruleVideoGenInformation();

            state._fsp--;

             current =iv_ruleVideoGenInformation; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVideoGenInformation"


    // $ANTLR start "ruleVideoGenInformation"
    // InternalVideoGen.g:151:1: ruleVideoGenInformation returns [EObject current=null] : ( () (otherlv_1= '@author' ( (lv_authorName_2_0= RULE_STRING ) ) ) (otherlv_3= '@version' ( (lv_version_4_0= RULE_STRING ) ) )? (otherlv_5= '@creation' ( (lv_creationDate_6_0= RULE_STRING ) ) )? ) ;
    public final EObject ruleVideoGenInformation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_authorName_2_0=null;
        Token otherlv_3=null;
        Token lv_version_4_0=null;
        Token otherlv_5=null;
        Token lv_creationDate_6_0=null;

         enterRule(); 
            
        try {
            // InternalVideoGen.g:154:28: ( ( () (otherlv_1= '@author' ( (lv_authorName_2_0= RULE_STRING ) ) ) (otherlv_3= '@version' ( (lv_version_4_0= RULE_STRING ) ) )? (otherlv_5= '@creation' ( (lv_creationDate_6_0= RULE_STRING ) ) )? ) )
            // InternalVideoGen.g:155:1: ( () (otherlv_1= '@author' ( (lv_authorName_2_0= RULE_STRING ) ) ) (otherlv_3= '@version' ( (lv_version_4_0= RULE_STRING ) ) )? (otherlv_5= '@creation' ( (lv_creationDate_6_0= RULE_STRING ) ) )? )
            {
            // InternalVideoGen.g:155:1: ( () (otherlv_1= '@author' ( (lv_authorName_2_0= RULE_STRING ) ) ) (otherlv_3= '@version' ( (lv_version_4_0= RULE_STRING ) ) )? (otherlv_5= '@creation' ( (lv_creationDate_6_0= RULE_STRING ) ) )? )
            // InternalVideoGen.g:155:2: () (otherlv_1= '@author' ( (lv_authorName_2_0= RULE_STRING ) ) ) (otherlv_3= '@version' ( (lv_version_4_0= RULE_STRING ) ) )? (otherlv_5= '@creation' ( (lv_creationDate_6_0= RULE_STRING ) ) )?
            {
            // InternalVideoGen.g:155:2: ()
            // InternalVideoGen.g:156:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getVideoGenInformationAccess().getVideoGenInformationAction_0(),
                        current);
                

            }

            // InternalVideoGen.g:161:2: (otherlv_1= '@author' ( (lv_authorName_2_0= RULE_STRING ) ) )
            // InternalVideoGen.g:161:4: otherlv_1= '@author' ( (lv_authorName_2_0= RULE_STRING ) )
            {
            otherlv_1=(Token)match(input,14,FOLLOW_7); 

                	newLeafNode(otherlv_1, grammarAccess.getVideoGenInformationAccess().getAuthorKeyword_1_0());
                
            // InternalVideoGen.g:165:1: ( (lv_authorName_2_0= RULE_STRING ) )
            // InternalVideoGen.g:166:1: (lv_authorName_2_0= RULE_STRING )
            {
            // InternalVideoGen.g:166:1: (lv_authorName_2_0= RULE_STRING )
            // InternalVideoGen.g:167:3: lv_authorName_2_0= RULE_STRING
            {
            lv_authorName_2_0=(Token)match(input,RULE_STRING,FOLLOW_8); 

            			newLeafNode(lv_authorName_2_0, grammarAccess.getVideoGenInformationAccess().getAuthorNameSTRINGTerminalRuleCall_1_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getVideoGenInformationRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"authorName",
                    		lv_authorName_2_0, 
                    		"org.eclipse.xtext.common.Terminals.STRING");
            	    

            }


            }


            }

            // InternalVideoGen.g:183:3: (otherlv_3= '@version' ( (lv_version_4_0= RULE_STRING ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==15) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalVideoGen.g:183:5: otherlv_3= '@version' ( (lv_version_4_0= RULE_STRING ) )
                    {
                    otherlv_3=(Token)match(input,15,FOLLOW_7); 

                        	newLeafNode(otherlv_3, grammarAccess.getVideoGenInformationAccess().getVersionKeyword_2_0());
                        
                    // InternalVideoGen.g:187:1: ( (lv_version_4_0= RULE_STRING ) )
                    // InternalVideoGen.g:188:1: (lv_version_4_0= RULE_STRING )
                    {
                    // InternalVideoGen.g:188:1: (lv_version_4_0= RULE_STRING )
                    // InternalVideoGen.g:189:3: lv_version_4_0= RULE_STRING
                    {
                    lv_version_4_0=(Token)match(input,RULE_STRING,FOLLOW_9); 

                    			newLeafNode(lv_version_4_0, grammarAccess.getVideoGenInformationAccess().getVersionSTRINGTerminalRuleCall_2_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getVideoGenInformationRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"version",
                            		lv_version_4_0, 
                            		"org.eclipse.xtext.common.Terminals.STRING");
                    	    

                    }


                    }


                    }
                    break;

            }

            // InternalVideoGen.g:205:4: (otherlv_5= '@creation' ( (lv_creationDate_6_0= RULE_STRING ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==16) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalVideoGen.g:205:6: otherlv_5= '@creation' ( (lv_creationDate_6_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,16,FOLLOW_7); 

                        	newLeafNode(otherlv_5, grammarAccess.getVideoGenInformationAccess().getCreationKeyword_3_0());
                        
                    // InternalVideoGen.g:209:1: ( (lv_creationDate_6_0= RULE_STRING ) )
                    // InternalVideoGen.g:210:1: (lv_creationDate_6_0= RULE_STRING )
                    {
                    // InternalVideoGen.g:210:1: (lv_creationDate_6_0= RULE_STRING )
                    // InternalVideoGen.g:211:3: lv_creationDate_6_0= RULE_STRING
                    {
                    lv_creationDate_6_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    			newLeafNode(lv_creationDate_6_0, grammarAccess.getVideoGenInformationAccess().getCreationDateSTRINGTerminalRuleCall_3_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getVideoGenInformationRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"creationDate",
                            		lv_creationDate_6_0, 
                            		"org.eclipse.xtext.common.Terminals.STRING");
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVideoGenInformation"


    // $ANTLR start "entryRuleVideoSeq"
    // InternalVideoGen.g:235:1: entryRuleVideoSeq returns [EObject current=null] : iv_ruleVideoSeq= ruleVideoSeq EOF ;
    public final EObject entryRuleVideoSeq() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVideoSeq = null;


        try {
            // InternalVideoGen.g:236:2: (iv_ruleVideoSeq= ruleVideoSeq EOF )
            // InternalVideoGen.g:237:2: iv_ruleVideoSeq= ruleVideoSeq EOF
            {
             newCompositeNode(grammarAccess.getVideoSeqRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVideoSeq=ruleVideoSeq();

            state._fsp--;

             current =iv_ruleVideoSeq; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVideoSeq"


    // $ANTLR start "ruleVideoSeq"
    // InternalVideoGen.g:244:1: ruleVideoSeq returns [EObject current=null] : (this_MandatoryVideoSeq_0= ruleMandatoryVideoSeq | this_OptionalVideoSeq_1= ruleOptionalVideoSeq | this_AlternativeVideoSeq_2= ruleAlternativeVideoSeq ) ;
    public final EObject ruleVideoSeq() throws RecognitionException {
        EObject current = null;

        EObject this_MandatoryVideoSeq_0 = null;

        EObject this_OptionalVideoSeq_1 = null;

        EObject this_AlternativeVideoSeq_2 = null;


         enterRule(); 
            
        try {
            // InternalVideoGen.g:247:28: ( (this_MandatoryVideoSeq_0= ruleMandatoryVideoSeq | this_OptionalVideoSeq_1= ruleOptionalVideoSeq | this_AlternativeVideoSeq_2= ruleAlternativeVideoSeq ) )
            // InternalVideoGen.g:248:1: (this_MandatoryVideoSeq_0= ruleMandatoryVideoSeq | this_OptionalVideoSeq_1= ruleOptionalVideoSeq | this_AlternativeVideoSeq_2= ruleAlternativeVideoSeq )
            {
            // InternalVideoGen.g:248:1: (this_MandatoryVideoSeq_0= ruleMandatoryVideoSeq | this_OptionalVideoSeq_1= ruleOptionalVideoSeq | this_AlternativeVideoSeq_2= ruleAlternativeVideoSeq )
            int alt5=3;
            switch ( input.LA(1) ) {
            case 17:
                {
                alt5=1;
                }
                break;
            case 18:
                {
                alt5=2;
                }
                break;
            case 19:
                {
                alt5=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalVideoGen.g:249:5: this_MandatoryVideoSeq_0= ruleMandatoryVideoSeq
                    {
                     
                            newCompositeNode(grammarAccess.getVideoSeqAccess().getMandatoryVideoSeqParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_MandatoryVideoSeq_0=ruleMandatoryVideoSeq();

                    state._fsp--;

                     
                            current = this_MandatoryVideoSeq_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalVideoGen.g:259:5: this_OptionalVideoSeq_1= ruleOptionalVideoSeq
                    {
                     
                            newCompositeNode(grammarAccess.getVideoSeqAccess().getOptionalVideoSeqParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_2);
                    this_OptionalVideoSeq_1=ruleOptionalVideoSeq();

                    state._fsp--;

                     
                            current = this_OptionalVideoSeq_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // InternalVideoGen.g:269:5: this_AlternativeVideoSeq_2= ruleAlternativeVideoSeq
                    {
                     
                            newCompositeNode(grammarAccess.getVideoSeqAccess().getAlternativeVideoSeqParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_2);
                    this_AlternativeVideoSeq_2=ruleAlternativeVideoSeq();

                    state._fsp--;

                     
                            current = this_AlternativeVideoSeq_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVideoSeq"


    // $ANTLR start "entryRuleMandatoryVideoSeq"
    // InternalVideoGen.g:285:1: entryRuleMandatoryVideoSeq returns [EObject current=null] : iv_ruleMandatoryVideoSeq= ruleMandatoryVideoSeq EOF ;
    public final EObject entryRuleMandatoryVideoSeq() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMandatoryVideoSeq = null;


        try {
            // InternalVideoGen.g:286:2: (iv_ruleMandatoryVideoSeq= ruleMandatoryVideoSeq EOF )
            // InternalVideoGen.g:287:2: iv_ruleMandatoryVideoSeq= ruleMandatoryVideoSeq EOF
            {
             newCompositeNode(grammarAccess.getMandatoryVideoSeqRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMandatoryVideoSeq=ruleMandatoryVideoSeq();

            state._fsp--;

             current =iv_ruleMandatoryVideoSeq; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMandatoryVideoSeq"


    // $ANTLR start "ruleMandatoryVideoSeq"
    // InternalVideoGen.g:294:1: ruleMandatoryVideoSeq returns [EObject current=null] : (otherlv_0= 'mandatory' ( (lv_description_1_0= ruleVideoDescription ) ) ) ;
    public final EObject ruleMandatoryVideoSeq() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_description_1_0 = null;


         enterRule(); 
            
        try {
            // InternalVideoGen.g:297:28: ( (otherlv_0= 'mandatory' ( (lv_description_1_0= ruleVideoDescription ) ) ) )
            // InternalVideoGen.g:298:1: (otherlv_0= 'mandatory' ( (lv_description_1_0= ruleVideoDescription ) ) )
            {
            // InternalVideoGen.g:298:1: (otherlv_0= 'mandatory' ( (lv_description_1_0= ruleVideoDescription ) ) )
            // InternalVideoGen.g:298:3: otherlv_0= 'mandatory' ( (lv_description_1_0= ruleVideoDescription ) )
            {
            otherlv_0=(Token)match(input,17,FOLLOW_10); 

                	newLeafNode(otherlv_0, grammarAccess.getMandatoryVideoSeqAccess().getMandatoryKeyword_0());
                
            // InternalVideoGen.g:302:1: ( (lv_description_1_0= ruleVideoDescription ) )
            // InternalVideoGen.g:303:1: (lv_description_1_0= ruleVideoDescription )
            {
            // InternalVideoGen.g:303:1: (lv_description_1_0= ruleVideoDescription )
            // InternalVideoGen.g:304:3: lv_description_1_0= ruleVideoDescription
            {
             
            	        newCompositeNode(grammarAccess.getMandatoryVideoSeqAccess().getDescriptionVideoDescriptionParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_description_1_0=ruleVideoDescription();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getMandatoryVideoSeqRule());
            	        }
                   		set(
                   			current, 
                   			"description",
                    		lv_description_1_0, 
                    		"org.xtext.example.mydsl.VideoGen.VideoDescription");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMandatoryVideoSeq"


    // $ANTLR start "entryRuleOptionalVideoSeq"
    // InternalVideoGen.g:328:1: entryRuleOptionalVideoSeq returns [EObject current=null] : iv_ruleOptionalVideoSeq= ruleOptionalVideoSeq EOF ;
    public final EObject entryRuleOptionalVideoSeq() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptionalVideoSeq = null;


        try {
            // InternalVideoGen.g:329:2: (iv_ruleOptionalVideoSeq= ruleOptionalVideoSeq EOF )
            // InternalVideoGen.g:330:2: iv_ruleOptionalVideoSeq= ruleOptionalVideoSeq EOF
            {
             newCompositeNode(grammarAccess.getOptionalVideoSeqRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOptionalVideoSeq=ruleOptionalVideoSeq();

            state._fsp--;

             current =iv_ruleOptionalVideoSeq; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOptionalVideoSeq"


    // $ANTLR start "ruleOptionalVideoSeq"
    // InternalVideoGen.g:337:1: ruleOptionalVideoSeq returns [EObject current=null] : (otherlv_0= 'optional' ( (lv_description_1_0= ruleVideoDescription ) ) ) ;
    public final EObject ruleOptionalVideoSeq() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_description_1_0 = null;


         enterRule(); 
            
        try {
            // InternalVideoGen.g:340:28: ( (otherlv_0= 'optional' ( (lv_description_1_0= ruleVideoDescription ) ) ) )
            // InternalVideoGen.g:341:1: (otherlv_0= 'optional' ( (lv_description_1_0= ruleVideoDescription ) ) )
            {
            // InternalVideoGen.g:341:1: (otherlv_0= 'optional' ( (lv_description_1_0= ruleVideoDescription ) ) )
            // InternalVideoGen.g:341:3: otherlv_0= 'optional' ( (lv_description_1_0= ruleVideoDescription ) )
            {
            otherlv_0=(Token)match(input,18,FOLLOW_10); 

                	newLeafNode(otherlv_0, grammarAccess.getOptionalVideoSeqAccess().getOptionalKeyword_0());
                
            // InternalVideoGen.g:345:1: ( (lv_description_1_0= ruleVideoDescription ) )
            // InternalVideoGen.g:346:1: (lv_description_1_0= ruleVideoDescription )
            {
            // InternalVideoGen.g:346:1: (lv_description_1_0= ruleVideoDescription )
            // InternalVideoGen.g:347:3: lv_description_1_0= ruleVideoDescription
            {
             
            	        newCompositeNode(grammarAccess.getOptionalVideoSeqAccess().getDescriptionVideoDescriptionParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_description_1_0=ruleVideoDescription();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getOptionalVideoSeqRule());
            	        }
                   		set(
                   			current, 
                   			"description",
                    		lv_description_1_0, 
                    		"org.xtext.example.mydsl.VideoGen.VideoDescription");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOptionalVideoSeq"


    // $ANTLR start "entryRuleAlternativeVideoSeq"
    // InternalVideoGen.g:371:1: entryRuleAlternativeVideoSeq returns [EObject current=null] : iv_ruleAlternativeVideoSeq= ruleAlternativeVideoSeq EOF ;
    public final EObject entryRuleAlternativeVideoSeq() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlternativeVideoSeq = null;


        try {
            // InternalVideoGen.g:372:2: (iv_ruleAlternativeVideoSeq= ruleAlternativeVideoSeq EOF )
            // InternalVideoGen.g:373:2: iv_ruleAlternativeVideoSeq= ruleAlternativeVideoSeq EOF
            {
             newCompositeNode(grammarAccess.getAlternativeVideoSeqRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAlternativeVideoSeq=ruleAlternativeVideoSeq();

            state._fsp--;

             current =iv_ruleAlternativeVideoSeq; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAlternativeVideoSeq"


    // $ANTLR start "ruleAlternativeVideoSeq"
    // InternalVideoGen.g:380:1: ruleAlternativeVideoSeq returns [EObject current=null] : (otherlv_0= 'alternatives' ( (lv_videoid_1_0= RULE_ID ) )? this_LEFT_BRACKET_2= RULE_LEFT_BRACKET ( (lv_videodescs_3_0= ruleVideoDescription ) )+ this_RIGHT_BRACKET_4= RULE_RIGHT_BRACKET ) ;
    public final EObject ruleAlternativeVideoSeq() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_videoid_1_0=null;
        Token this_LEFT_BRACKET_2=null;
        Token this_RIGHT_BRACKET_4=null;
        EObject lv_videodescs_3_0 = null;


         enterRule(); 
            
        try {
            // InternalVideoGen.g:383:28: ( (otherlv_0= 'alternatives' ( (lv_videoid_1_0= RULE_ID ) )? this_LEFT_BRACKET_2= RULE_LEFT_BRACKET ( (lv_videodescs_3_0= ruleVideoDescription ) )+ this_RIGHT_BRACKET_4= RULE_RIGHT_BRACKET ) )
            // InternalVideoGen.g:384:1: (otherlv_0= 'alternatives' ( (lv_videoid_1_0= RULE_ID ) )? this_LEFT_BRACKET_2= RULE_LEFT_BRACKET ( (lv_videodescs_3_0= ruleVideoDescription ) )+ this_RIGHT_BRACKET_4= RULE_RIGHT_BRACKET )
            {
            // InternalVideoGen.g:384:1: (otherlv_0= 'alternatives' ( (lv_videoid_1_0= RULE_ID ) )? this_LEFT_BRACKET_2= RULE_LEFT_BRACKET ( (lv_videodescs_3_0= ruleVideoDescription ) )+ this_RIGHT_BRACKET_4= RULE_RIGHT_BRACKET )
            // InternalVideoGen.g:384:3: otherlv_0= 'alternatives' ( (lv_videoid_1_0= RULE_ID ) )? this_LEFT_BRACKET_2= RULE_LEFT_BRACKET ( (lv_videodescs_3_0= ruleVideoDescription ) )+ this_RIGHT_BRACKET_4= RULE_RIGHT_BRACKET
            {
            otherlv_0=(Token)match(input,19,FOLLOW_11); 

                	newLeafNode(otherlv_0, grammarAccess.getAlternativeVideoSeqAccess().getAlternativesKeyword_0());
                
            // InternalVideoGen.g:388:1: ( (lv_videoid_1_0= RULE_ID ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalVideoGen.g:389:1: (lv_videoid_1_0= RULE_ID )
                    {
                    // InternalVideoGen.g:389:1: (lv_videoid_1_0= RULE_ID )
                    // InternalVideoGen.g:390:3: lv_videoid_1_0= RULE_ID
                    {
                    lv_videoid_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

                    			newLeafNode(lv_videoid_1_0, grammarAccess.getAlternativeVideoSeqAccess().getVideoidIDTerminalRuleCall_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAlternativeVideoSeqRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"videoid",
                            		lv_videoid_1_0, 
                            		"org.eclipse.xtext.common.Terminals.ID");
                    	    

                    }


                    }
                    break;

            }

            this_LEFT_BRACKET_2=(Token)match(input,RULE_LEFT_BRACKET,FOLLOW_10); 
             
                newLeafNode(this_LEFT_BRACKET_2, grammarAccess.getAlternativeVideoSeqAccess().getLEFT_BRACKETTerminalRuleCall_2()); 
                
            // InternalVideoGen.g:410:1: ( (lv_videodescs_3_0= ruleVideoDescription ) )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==20) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalVideoGen.g:411:1: (lv_videodescs_3_0= ruleVideoDescription )
            	    {
            	    // InternalVideoGen.g:411:1: (lv_videodescs_3_0= ruleVideoDescription )
            	    // InternalVideoGen.g:412:3: lv_videodescs_3_0= ruleVideoDescription
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAlternativeVideoSeqAccess().getVideodescsVideoDescriptionParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_12);
            	    lv_videodescs_3_0=ruleVideoDescription();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getAlternativeVideoSeqRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"videodescs",
            	            		lv_videodescs_3_0, 
            	            		"org.xtext.example.mydsl.VideoGen.VideoDescription");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);

            this_RIGHT_BRACKET_4=(Token)match(input,RULE_RIGHT_BRACKET,FOLLOW_2); 
             
                newLeafNode(this_RIGHT_BRACKET_4, grammarAccess.getAlternativeVideoSeqAccess().getRIGHT_BRACKETTerminalRuleCall_4()); 
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAlternativeVideoSeq"


    // $ANTLR start "entryRuleVideoDescription"
    // InternalVideoGen.g:440:1: entryRuleVideoDescription returns [EObject current=null] : iv_ruleVideoDescription= ruleVideoDescription EOF ;
    public final EObject entryRuleVideoDescription() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVideoDescription = null;


        try {
            // InternalVideoGen.g:441:2: (iv_ruleVideoDescription= ruleVideoDescription EOF )
            // InternalVideoGen.g:442:2: iv_ruleVideoDescription= ruleVideoDescription EOF
            {
             newCompositeNode(grammarAccess.getVideoDescriptionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVideoDescription=ruleVideoDescription();

            state._fsp--;

             current =iv_ruleVideoDescription; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVideoDescription"


    // $ANTLR start "ruleVideoDescription"
    // InternalVideoGen.g:449:1: ruleVideoDescription returns [EObject current=null] : (otherlv_0= 'videoseq' ( (lv_videoid_1_0= RULE_ID ) )? ( (lv_location_2_0= RULE_STRING ) ) (this_LEFT_BRACKET_3= RULE_LEFT_BRACKET (otherlv_4= 'duration' ( (lv_duration_5_0= RULE_INT ) ) )? (otherlv_6= 'probability' ( (lv_probability_7_0= RULE_INT ) ) )? (otherlv_8= 'textIncrust' ( (lv_textIncrust_9_0= RULE_STRING ) ) )? (otherlv_10= 'size' ( (lv_size_11_0= RULE_INT ) ) )? (otherlv_12= 'description' ( (lv_description_13_0= RULE_STRING ) ) )? (otherlv_14= 'subtitle' ( (lv_subtitle_15_0= ruleSubtitle ) ) )? (otherlv_16= 'text' ( (lv_text_17_0= ruleText ) ) )? (otherlv_18= 'filter' ( (lv_filter_19_0= ruleFilter ) ) )? this_RIGHT_BRACKET_20= RULE_RIGHT_BRACKET )? ) ;
    public final EObject ruleVideoDescription() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_videoid_1_0=null;
        Token lv_location_2_0=null;
        Token this_LEFT_BRACKET_3=null;
        Token otherlv_4=null;
        Token lv_duration_5_0=null;
        Token otherlv_6=null;
        Token lv_probability_7_0=null;
        Token otherlv_8=null;
        Token lv_textIncrust_9_0=null;
        Token otherlv_10=null;
        Token lv_size_11_0=null;
        Token otherlv_12=null;
        Token lv_description_13_0=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token this_RIGHT_BRACKET_20=null;
        EObject lv_subtitle_15_0 = null;

        EObject lv_text_17_0 = null;

        EObject lv_filter_19_0 = null;


         enterRule(); 
            
        try {
            // InternalVideoGen.g:452:28: ( (otherlv_0= 'videoseq' ( (lv_videoid_1_0= RULE_ID ) )? ( (lv_location_2_0= RULE_STRING ) ) (this_LEFT_BRACKET_3= RULE_LEFT_BRACKET (otherlv_4= 'duration' ( (lv_duration_5_0= RULE_INT ) ) )? (otherlv_6= 'probability' ( (lv_probability_7_0= RULE_INT ) ) )? (otherlv_8= 'textIncrust' ( (lv_textIncrust_9_0= RULE_STRING ) ) )? (otherlv_10= 'size' ( (lv_size_11_0= RULE_INT ) ) )? (otherlv_12= 'description' ( (lv_description_13_0= RULE_STRING ) ) )? (otherlv_14= 'subtitle' ( (lv_subtitle_15_0= ruleSubtitle ) ) )? (otherlv_16= 'text' ( (lv_text_17_0= ruleText ) ) )? (otherlv_18= 'filter' ( (lv_filter_19_0= ruleFilter ) ) )? this_RIGHT_BRACKET_20= RULE_RIGHT_BRACKET )? ) )
            // InternalVideoGen.g:453:1: (otherlv_0= 'videoseq' ( (lv_videoid_1_0= RULE_ID ) )? ( (lv_location_2_0= RULE_STRING ) ) (this_LEFT_BRACKET_3= RULE_LEFT_BRACKET (otherlv_4= 'duration' ( (lv_duration_5_0= RULE_INT ) ) )? (otherlv_6= 'probability' ( (lv_probability_7_0= RULE_INT ) ) )? (otherlv_8= 'textIncrust' ( (lv_textIncrust_9_0= RULE_STRING ) ) )? (otherlv_10= 'size' ( (lv_size_11_0= RULE_INT ) ) )? (otherlv_12= 'description' ( (lv_description_13_0= RULE_STRING ) ) )? (otherlv_14= 'subtitle' ( (lv_subtitle_15_0= ruleSubtitle ) ) )? (otherlv_16= 'text' ( (lv_text_17_0= ruleText ) ) )? (otherlv_18= 'filter' ( (lv_filter_19_0= ruleFilter ) ) )? this_RIGHT_BRACKET_20= RULE_RIGHT_BRACKET )? )
            {
            // InternalVideoGen.g:453:1: (otherlv_0= 'videoseq' ( (lv_videoid_1_0= RULE_ID ) )? ( (lv_location_2_0= RULE_STRING ) ) (this_LEFT_BRACKET_3= RULE_LEFT_BRACKET (otherlv_4= 'duration' ( (lv_duration_5_0= RULE_INT ) ) )? (otherlv_6= 'probability' ( (lv_probability_7_0= RULE_INT ) ) )? (otherlv_8= 'textIncrust' ( (lv_textIncrust_9_0= RULE_STRING ) ) )? (otherlv_10= 'size' ( (lv_size_11_0= RULE_INT ) ) )? (otherlv_12= 'description' ( (lv_description_13_0= RULE_STRING ) ) )? (otherlv_14= 'subtitle' ( (lv_subtitle_15_0= ruleSubtitle ) ) )? (otherlv_16= 'text' ( (lv_text_17_0= ruleText ) ) )? (otherlv_18= 'filter' ( (lv_filter_19_0= ruleFilter ) ) )? this_RIGHT_BRACKET_20= RULE_RIGHT_BRACKET )? )
            // InternalVideoGen.g:453:3: otherlv_0= 'videoseq' ( (lv_videoid_1_0= RULE_ID ) )? ( (lv_location_2_0= RULE_STRING ) ) (this_LEFT_BRACKET_3= RULE_LEFT_BRACKET (otherlv_4= 'duration' ( (lv_duration_5_0= RULE_INT ) ) )? (otherlv_6= 'probability' ( (lv_probability_7_0= RULE_INT ) ) )? (otherlv_8= 'textIncrust' ( (lv_textIncrust_9_0= RULE_STRING ) ) )? (otherlv_10= 'size' ( (lv_size_11_0= RULE_INT ) ) )? (otherlv_12= 'description' ( (lv_description_13_0= RULE_STRING ) ) )? (otherlv_14= 'subtitle' ( (lv_subtitle_15_0= ruleSubtitle ) ) )? (otherlv_16= 'text' ( (lv_text_17_0= ruleText ) ) )? (otherlv_18= 'filter' ( (lv_filter_19_0= ruleFilter ) ) )? this_RIGHT_BRACKET_20= RULE_RIGHT_BRACKET )?
            {
            otherlv_0=(Token)match(input,20,FOLLOW_13); 

                	newLeafNode(otherlv_0, grammarAccess.getVideoDescriptionAccess().getVideoseqKeyword_0());
                
            // InternalVideoGen.g:457:1: ( (lv_videoid_1_0= RULE_ID ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalVideoGen.g:458:1: (lv_videoid_1_0= RULE_ID )
                    {
                    // InternalVideoGen.g:458:1: (lv_videoid_1_0= RULE_ID )
                    // InternalVideoGen.g:459:3: lv_videoid_1_0= RULE_ID
                    {
                    lv_videoid_1_0=(Token)match(input,RULE_ID,FOLLOW_7); 

                    			newLeafNode(lv_videoid_1_0, grammarAccess.getVideoDescriptionAccess().getVideoidIDTerminalRuleCall_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getVideoDescriptionRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"videoid",
                            		lv_videoid_1_0, 
                            		"org.eclipse.xtext.common.Terminals.ID");
                    	    

                    }


                    }
                    break;

            }

            // InternalVideoGen.g:475:3: ( (lv_location_2_0= RULE_STRING ) )
            // InternalVideoGen.g:476:1: (lv_location_2_0= RULE_STRING )
            {
            // InternalVideoGen.g:476:1: (lv_location_2_0= RULE_STRING )
            // InternalVideoGen.g:477:3: lv_location_2_0= RULE_STRING
            {
            lv_location_2_0=(Token)match(input,RULE_STRING,FOLLOW_14); 

            			newLeafNode(lv_location_2_0, grammarAccess.getVideoDescriptionAccess().getLocationSTRINGTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getVideoDescriptionRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"location",
                    		lv_location_2_0, 
                    		"org.eclipse.xtext.common.Terminals.STRING");
            	    

            }


            }

            // InternalVideoGen.g:493:2: (this_LEFT_BRACKET_3= RULE_LEFT_BRACKET (otherlv_4= 'duration' ( (lv_duration_5_0= RULE_INT ) ) )? (otherlv_6= 'probability' ( (lv_probability_7_0= RULE_INT ) ) )? (otherlv_8= 'textIncrust' ( (lv_textIncrust_9_0= RULE_STRING ) ) )? (otherlv_10= 'size' ( (lv_size_11_0= RULE_INT ) ) )? (otherlv_12= 'description' ( (lv_description_13_0= RULE_STRING ) ) )? (otherlv_14= 'subtitle' ( (lv_subtitle_15_0= ruleSubtitle ) ) )? (otherlv_16= 'text' ( (lv_text_17_0= ruleText ) ) )? (otherlv_18= 'filter' ( (lv_filter_19_0= ruleFilter ) ) )? this_RIGHT_BRACKET_20= RULE_RIGHT_BRACKET )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_LEFT_BRACKET) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalVideoGen.g:493:3: this_LEFT_BRACKET_3= RULE_LEFT_BRACKET (otherlv_4= 'duration' ( (lv_duration_5_0= RULE_INT ) ) )? (otherlv_6= 'probability' ( (lv_probability_7_0= RULE_INT ) ) )? (otherlv_8= 'textIncrust' ( (lv_textIncrust_9_0= RULE_STRING ) ) )? (otherlv_10= 'size' ( (lv_size_11_0= RULE_INT ) ) )? (otherlv_12= 'description' ( (lv_description_13_0= RULE_STRING ) ) )? (otherlv_14= 'subtitle' ( (lv_subtitle_15_0= ruleSubtitle ) ) )? (otherlv_16= 'text' ( (lv_text_17_0= ruleText ) ) )? (otherlv_18= 'filter' ( (lv_filter_19_0= ruleFilter ) ) )? this_RIGHT_BRACKET_20= RULE_RIGHT_BRACKET
                    {
                    this_LEFT_BRACKET_3=(Token)match(input,RULE_LEFT_BRACKET,FOLLOW_15); 
                     
                        newLeafNode(this_LEFT_BRACKET_3, grammarAccess.getVideoDescriptionAccess().getLEFT_BRACKETTerminalRuleCall_3_0()); 
                        
                    // InternalVideoGen.g:497:1: (otherlv_4= 'duration' ( (lv_duration_5_0= RULE_INT ) ) )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==21) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // InternalVideoGen.g:497:3: otherlv_4= 'duration' ( (lv_duration_5_0= RULE_INT ) )
                            {
                            otherlv_4=(Token)match(input,21,FOLLOW_16); 

                                	newLeafNode(otherlv_4, grammarAccess.getVideoDescriptionAccess().getDurationKeyword_3_1_0());
                                
                            // InternalVideoGen.g:501:1: ( (lv_duration_5_0= RULE_INT ) )
                            // InternalVideoGen.g:502:1: (lv_duration_5_0= RULE_INT )
                            {
                            // InternalVideoGen.g:502:1: (lv_duration_5_0= RULE_INT )
                            // InternalVideoGen.g:503:3: lv_duration_5_0= RULE_INT
                            {
                            lv_duration_5_0=(Token)match(input,RULE_INT,FOLLOW_17); 

                            			newLeafNode(lv_duration_5_0, grammarAccess.getVideoDescriptionAccess().getDurationINTTerminalRuleCall_3_1_1_0()); 
                            		

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getVideoDescriptionRule());
                            	        }
                                   		setWithLastConsumed(
                                   			current, 
                                   			"duration",
                                    		lv_duration_5_0, 
                                    		"org.eclipse.xtext.common.Terminals.INT");
                            	    

                            }


                            }


                            }
                            break;

                    }

                    // InternalVideoGen.g:519:4: (otherlv_6= 'probability' ( (lv_probability_7_0= RULE_INT ) ) )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==22) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // InternalVideoGen.g:519:6: otherlv_6= 'probability' ( (lv_probability_7_0= RULE_INT ) )
                            {
                            otherlv_6=(Token)match(input,22,FOLLOW_16); 

                                	newLeafNode(otherlv_6, grammarAccess.getVideoDescriptionAccess().getProbabilityKeyword_3_2_0());
                                
                            // InternalVideoGen.g:523:1: ( (lv_probability_7_0= RULE_INT ) )
                            // InternalVideoGen.g:524:1: (lv_probability_7_0= RULE_INT )
                            {
                            // InternalVideoGen.g:524:1: (lv_probability_7_0= RULE_INT )
                            // InternalVideoGen.g:525:3: lv_probability_7_0= RULE_INT
                            {
                            lv_probability_7_0=(Token)match(input,RULE_INT,FOLLOW_18); 

                            			newLeafNode(lv_probability_7_0, grammarAccess.getVideoDescriptionAccess().getProbabilityINTTerminalRuleCall_3_2_1_0()); 
                            		

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getVideoDescriptionRule());
                            	        }
                                   		setWithLastConsumed(
                                   			current, 
                                   			"probability",
                                    		lv_probability_7_0, 
                                    		"org.eclipse.xtext.common.Terminals.INT");
                            	    

                            }


                            }


                            }
                            break;

                    }

                    // InternalVideoGen.g:541:4: (otherlv_8= 'textIncrust' ( (lv_textIncrust_9_0= RULE_STRING ) ) )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==23) ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // InternalVideoGen.g:541:6: otherlv_8= 'textIncrust' ( (lv_textIncrust_9_0= RULE_STRING ) )
                            {
                            otherlv_8=(Token)match(input,23,FOLLOW_7); 

                                	newLeafNode(otherlv_8, grammarAccess.getVideoDescriptionAccess().getTextIncrustKeyword_3_3_0());
                                
                            // InternalVideoGen.g:545:1: ( (lv_textIncrust_9_0= RULE_STRING ) )
                            // InternalVideoGen.g:546:1: (lv_textIncrust_9_0= RULE_STRING )
                            {
                            // InternalVideoGen.g:546:1: (lv_textIncrust_9_0= RULE_STRING )
                            // InternalVideoGen.g:547:3: lv_textIncrust_9_0= RULE_STRING
                            {
                            lv_textIncrust_9_0=(Token)match(input,RULE_STRING,FOLLOW_19); 

                            			newLeafNode(lv_textIncrust_9_0, grammarAccess.getVideoDescriptionAccess().getTextIncrustSTRINGTerminalRuleCall_3_3_1_0()); 
                            		

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getVideoDescriptionRule());
                            	        }
                                   		setWithLastConsumed(
                                   			current, 
                                   			"textIncrust",
                                    		lv_textIncrust_9_0, 
                                    		"org.eclipse.xtext.common.Terminals.STRING");
                            	    

                            }


                            }


                            }
                            break;

                    }

                    // InternalVideoGen.g:563:4: (otherlv_10= 'size' ( (lv_size_11_0= RULE_INT ) ) )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==24) ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // InternalVideoGen.g:563:6: otherlv_10= 'size' ( (lv_size_11_0= RULE_INT ) )
                            {
                            otherlv_10=(Token)match(input,24,FOLLOW_16); 

                                	newLeafNode(otherlv_10, grammarAccess.getVideoDescriptionAccess().getSizeKeyword_3_4_0());
                                
                            // InternalVideoGen.g:567:1: ( (lv_size_11_0= RULE_INT ) )
                            // InternalVideoGen.g:568:1: (lv_size_11_0= RULE_INT )
                            {
                            // InternalVideoGen.g:568:1: (lv_size_11_0= RULE_INT )
                            // InternalVideoGen.g:569:3: lv_size_11_0= RULE_INT
                            {
                            lv_size_11_0=(Token)match(input,RULE_INT,FOLLOW_20); 

                            			newLeafNode(lv_size_11_0, grammarAccess.getVideoDescriptionAccess().getSizeINTTerminalRuleCall_3_4_1_0()); 
                            		

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getVideoDescriptionRule());
                            	        }
                                   		setWithLastConsumed(
                                   			current, 
                                   			"size",
                                    		lv_size_11_0, 
                                    		"org.eclipse.xtext.common.Terminals.INT");
                            	    

                            }


                            }


                            }
                            break;

                    }

                    // InternalVideoGen.g:585:4: (otherlv_12= 'description' ( (lv_description_13_0= RULE_STRING ) ) )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==25) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // InternalVideoGen.g:585:6: otherlv_12= 'description' ( (lv_description_13_0= RULE_STRING ) )
                            {
                            otherlv_12=(Token)match(input,25,FOLLOW_7); 

                                	newLeafNode(otherlv_12, grammarAccess.getVideoDescriptionAccess().getDescriptionKeyword_3_5_0());
                                
                            // InternalVideoGen.g:589:1: ( (lv_description_13_0= RULE_STRING ) )
                            // InternalVideoGen.g:590:1: (lv_description_13_0= RULE_STRING )
                            {
                            // InternalVideoGen.g:590:1: (lv_description_13_0= RULE_STRING )
                            // InternalVideoGen.g:591:3: lv_description_13_0= RULE_STRING
                            {
                            lv_description_13_0=(Token)match(input,RULE_STRING,FOLLOW_21); 

                            			newLeafNode(lv_description_13_0, grammarAccess.getVideoDescriptionAccess().getDescriptionSTRINGTerminalRuleCall_3_5_1_0()); 
                            		

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getVideoDescriptionRule());
                            	        }
                                   		setWithLastConsumed(
                                   			current, 
                                   			"description",
                                    		lv_description_13_0, 
                                    		"org.eclipse.xtext.common.Terminals.STRING");
                            	    

                            }


                            }


                            }
                            break;

                    }

                    // InternalVideoGen.g:607:4: (otherlv_14= 'subtitle' ( (lv_subtitle_15_0= ruleSubtitle ) ) )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==26) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // InternalVideoGen.g:607:6: otherlv_14= 'subtitle' ( (lv_subtitle_15_0= ruleSubtitle ) )
                            {
                            otherlv_14=(Token)match(input,26,FOLLOW_22); 

                                	newLeafNode(otherlv_14, grammarAccess.getVideoDescriptionAccess().getSubtitleKeyword_3_6_0());
                                
                            // InternalVideoGen.g:611:1: ( (lv_subtitle_15_0= ruleSubtitle ) )
                            // InternalVideoGen.g:612:1: (lv_subtitle_15_0= ruleSubtitle )
                            {
                            // InternalVideoGen.g:612:1: (lv_subtitle_15_0= ruleSubtitle )
                            // InternalVideoGen.g:613:3: lv_subtitle_15_0= ruleSubtitle
                            {
                             
                            	        newCompositeNode(grammarAccess.getVideoDescriptionAccess().getSubtitleSubtitleParserRuleCall_3_6_1_0()); 
                            	    
                            pushFollow(FOLLOW_23);
                            lv_subtitle_15_0=ruleSubtitle();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getVideoDescriptionRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"subtitle",
                                    		lv_subtitle_15_0, 
                                    		"org.xtext.example.mydsl.VideoGen.Subtitle");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }

                    // InternalVideoGen.g:629:4: (otherlv_16= 'text' ( (lv_text_17_0= ruleText ) ) )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==27) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // InternalVideoGen.g:629:6: otherlv_16= 'text' ( (lv_text_17_0= ruleText ) )
                            {
                            otherlv_16=(Token)match(input,27,FOLLOW_4); 

                                	newLeafNode(otherlv_16, grammarAccess.getVideoDescriptionAccess().getTextKeyword_3_7_0());
                                
                            // InternalVideoGen.g:633:1: ( (lv_text_17_0= ruleText ) )
                            // InternalVideoGen.g:634:1: (lv_text_17_0= ruleText )
                            {
                            // InternalVideoGen.g:634:1: (lv_text_17_0= ruleText )
                            // InternalVideoGen.g:635:3: lv_text_17_0= ruleText
                            {
                             
                            	        newCompositeNode(grammarAccess.getVideoDescriptionAccess().getTextTextParserRuleCall_3_7_1_0()); 
                            	    
                            pushFollow(FOLLOW_24);
                            lv_text_17_0=ruleText();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getVideoDescriptionRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"text",
                                    		lv_text_17_0, 
                                    		"org.xtext.example.mydsl.VideoGen.Text");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }

                    // InternalVideoGen.g:651:4: (otherlv_18= 'filter' ( (lv_filter_19_0= ruleFilter ) ) )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==28) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // InternalVideoGen.g:651:6: otherlv_18= 'filter' ( (lv_filter_19_0= ruleFilter ) )
                            {
                            otherlv_18=(Token)match(input,28,FOLLOW_25); 

                                	newLeafNode(otherlv_18, grammarAccess.getVideoDescriptionAccess().getFilterKeyword_3_8_0());
                                
                            // InternalVideoGen.g:655:1: ( (lv_filter_19_0= ruleFilter ) )
                            // InternalVideoGen.g:656:1: (lv_filter_19_0= ruleFilter )
                            {
                            // InternalVideoGen.g:656:1: (lv_filter_19_0= ruleFilter )
                            // InternalVideoGen.g:657:3: lv_filter_19_0= ruleFilter
                            {
                             
                            	        newCompositeNode(grammarAccess.getVideoDescriptionAccess().getFilterFilterParserRuleCall_3_8_1_0()); 
                            	    
                            pushFollow(FOLLOW_26);
                            lv_filter_19_0=ruleFilter();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getVideoDescriptionRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"filter",
                                    		lv_filter_19_0, 
                                    		"org.xtext.example.mydsl.VideoGen.Filter");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }

                    this_RIGHT_BRACKET_20=(Token)match(input,RULE_RIGHT_BRACKET,FOLLOW_2); 
                     
                        newLeafNode(this_RIGHT_BRACKET_20, grammarAccess.getVideoDescriptionAccess().getRIGHT_BRACKETTerminalRuleCall_3_9()); 
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVideoDescription"


    // $ANTLR start "entryRuleSubtitle"
    // InternalVideoGen.g:685:1: entryRuleSubtitle returns [EObject current=null] : iv_ruleSubtitle= ruleSubtitle EOF ;
    public final EObject entryRuleSubtitle() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubtitle = null;


        try {
            // InternalVideoGen.g:686:2: (iv_ruleSubtitle= ruleSubtitle EOF )
            // InternalVideoGen.g:687:2: iv_ruleSubtitle= ruleSubtitle EOF
            {
             newCompositeNode(grammarAccess.getSubtitleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSubtitle=ruleSubtitle();

            state._fsp--;

             current =iv_ruleSubtitle; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSubtitle"


    // $ANTLR start "ruleSubtitle"
    // InternalVideoGen.g:694:1: ruleSubtitle returns [EObject current=null] : (otherlv_0= 'subtitle' ( (lv_text_1_0= RULE_STRING ) ) (this_LEFT_BRACKET_2= RULE_LEFT_BRACKET (otherlv_3= 'color' ( (lv_colorfont_4_0= RULE_STRING ) ) )? (otherlv_5= 'size' ( (lv_size_6_0= RULE_INT ) ) )? this_RIGHT_BRACKET_7= RULE_RIGHT_BRACKET )? ) ;
    public final EObject ruleSubtitle() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_text_1_0=null;
        Token this_LEFT_BRACKET_2=null;
        Token otherlv_3=null;
        Token lv_colorfont_4_0=null;
        Token otherlv_5=null;
        Token lv_size_6_0=null;
        Token this_RIGHT_BRACKET_7=null;

         enterRule(); 
            
        try {
            // InternalVideoGen.g:697:28: ( (otherlv_0= 'subtitle' ( (lv_text_1_0= RULE_STRING ) ) (this_LEFT_BRACKET_2= RULE_LEFT_BRACKET (otherlv_3= 'color' ( (lv_colorfont_4_0= RULE_STRING ) ) )? (otherlv_5= 'size' ( (lv_size_6_0= RULE_INT ) ) )? this_RIGHT_BRACKET_7= RULE_RIGHT_BRACKET )? ) )
            // InternalVideoGen.g:698:1: (otherlv_0= 'subtitle' ( (lv_text_1_0= RULE_STRING ) ) (this_LEFT_BRACKET_2= RULE_LEFT_BRACKET (otherlv_3= 'color' ( (lv_colorfont_4_0= RULE_STRING ) ) )? (otherlv_5= 'size' ( (lv_size_6_0= RULE_INT ) ) )? this_RIGHT_BRACKET_7= RULE_RIGHT_BRACKET )? )
            {
            // InternalVideoGen.g:698:1: (otherlv_0= 'subtitle' ( (lv_text_1_0= RULE_STRING ) ) (this_LEFT_BRACKET_2= RULE_LEFT_BRACKET (otherlv_3= 'color' ( (lv_colorfont_4_0= RULE_STRING ) ) )? (otherlv_5= 'size' ( (lv_size_6_0= RULE_INT ) ) )? this_RIGHT_BRACKET_7= RULE_RIGHT_BRACKET )? )
            // InternalVideoGen.g:698:3: otherlv_0= 'subtitle' ( (lv_text_1_0= RULE_STRING ) ) (this_LEFT_BRACKET_2= RULE_LEFT_BRACKET (otherlv_3= 'color' ( (lv_colorfont_4_0= RULE_STRING ) ) )? (otherlv_5= 'size' ( (lv_size_6_0= RULE_INT ) ) )? this_RIGHT_BRACKET_7= RULE_RIGHT_BRACKET )?
            {
            otherlv_0=(Token)match(input,26,FOLLOW_7); 

                	newLeafNode(otherlv_0, grammarAccess.getSubtitleAccess().getSubtitleKeyword_0());
                
            // InternalVideoGen.g:702:1: ( (lv_text_1_0= RULE_STRING ) )
            // InternalVideoGen.g:703:1: (lv_text_1_0= RULE_STRING )
            {
            // InternalVideoGen.g:703:1: (lv_text_1_0= RULE_STRING )
            // InternalVideoGen.g:704:3: lv_text_1_0= RULE_STRING
            {
            lv_text_1_0=(Token)match(input,RULE_STRING,FOLLOW_14); 

            			newLeafNode(lv_text_1_0, grammarAccess.getSubtitleAccess().getTextSTRINGTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSubtitleRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"text",
                    		lv_text_1_0, 
                    		"org.eclipse.xtext.common.Terminals.STRING");
            	    

            }


            }

            // InternalVideoGen.g:720:2: (this_LEFT_BRACKET_2= RULE_LEFT_BRACKET (otherlv_3= 'color' ( (lv_colorfont_4_0= RULE_STRING ) ) )? (otherlv_5= 'size' ( (lv_size_6_0= RULE_INT ) ) )? this_RIGHT_BRACKET_7= RULE_RIGHT_BRACKET )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_LEFT_BRACKET) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalVideoGen.g:720:3: this_LEFT_BRACKET_2= RULE_LEFT_BRACKET (otherlv_3= 'color' ( (lv_colorfont_4_0= RULE_STRING ) ) )? (otherlv_5= 'size' ( (lv_size_6_0= RULE_INT ) ) )? this_RIGHT_BRACKET_7= RULE_RIGHT_BRACKET
                    {
                    this_LEFT_BRACKET_2=(Token)match(input,RULE_LEFT_BRACKET,FOLLOW_27); 
                     
                        newLeafNode(this_LEFT_BRACKET_2, grammarAccess.getSubtitleAccess().getLEFT_BRACKETTerminalRuleCall_2_0()); 
                        
                    // InternalVideoGen.g:724:1: (otherlv_3= 'color' ( (lv_colorfont_4_0= RULE_STRING ) ) )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==29) ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // InternalVideoGen.g:724:3: otherlv_3= 'color' ( (lv_colorfont_4_0= RULE_STRING ) )
                            {
                            otherlv_3=(Token)match(input,29,FOLLOW_7); 

                                	newLeafNode(otherlv_3, grammarAccess.getSubtitleAccess().getColorKeyword_2_1_0());
                                
                            // InternalVideoGen.g:728:1: ( (lv_colorfont_4_0= RULE_STRING ) )
                            // InternalVideoGen.g:729:1: (lv_colorfont_4_0= RULE_STRING )
                            {
                            // InternalVideoGen.g:729:1: (lv_colorfont_4_0= RULE_STRING )
                            // InternalVideoGen.g:730:3: lv_colorfont_4_0= RULE_STRING
                            {
                            lv_colorfont_4_0=(Token)match(input,RULE_STRING,FOLLOW_28); 

                            			newLeafNode(lv_colorfont_4_0, grammarAccess.getSubtitleAccess().getColorfontSTRINGTerminalRuleCall_2_1_1_0()); 
                            		

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getSubtitleRule());
                            	        }
                                   		setWithLastConsumed(
                                   			current, 
                                   			"colorfont",
                                    		lv_colorfont_4_0, 
                                    		"org.eclipse.xtext.common.Terminals.STRING");
                            	    

                            }


                            }


                            }
                            break;

                    }

                    // InternalVideoGen.g:746:4: (otherlv_5= 'size' ( (lv_size_6_0= RULE_INT ) ) )?
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==24) ) {
                        alt19=1;
                    }
                    switch (alt19) {
                        case 1 :
                            // InternalVideoGen.g:746:6: otherlv_5= 'size' ( (lv_size_6_0= RULE_INT ) )
                            {
                            otherlv_5=(Token)match(input,24,FOLLOW_16); 

                                	newLeafNode(otherlv_5, grammarAccess.getSubtitleAccess().getSizeKeyword_2_2_0());
                                
                            // InternalVideoGen.g:750:1: ( (lv_size_6_0= RULE_INT ) )
                            // InternalVideoGen.g:751:1: (lv_size_6_0= RULE_INT )
                            {
                            // InternalVideoGen.g:751:1: (lv_size_6_0= RULE_INT )
                            // InternalVideoGen.g:752:3: lv_size_6_0= RULE_INT
                            {
                            lv_size_6_0=(Token)match(input,RULE_INT,FOLLOW_26); 

                            			newLeafNode(lv_size_6_0, grammarAccess.getSubtitleAccess().getSizeINTTerminalRuleCall_2_2_1_0()); 
                            		

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getSubtitleRule());
                            	        }
                                   		setWithLastConsumed(
                                   			current, 
                                   			"size",
                                    		lv_size_6_0, 
                                    		"org.eclipse.xtext.common.Terminals.INT");
                            	    

                            }


                            }


                            }
                            break;

                    }

                    this_RIGHT_BRACKET_7=(Token)match(input,RULE_RIGHT_BRACKET,FOLLOW_2); 
                     
                        newLeafNode(this_RIGHT_BRACKET_7, grammarAccess.getSubtitleAccess().getRIGHT_BRACKETTerminalRuleCall_2_3()); 
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSubtitle"


    // $ANTLR start "entryRuleText"
    // InternalVideoGen.g:780:1: entryRuleText returns [EObject current=null] : iv_ruleText= ruleText EOF ;
    public final EObject entryRuleText() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleText = null;


        try {
            // InternalVideoGen.g:781:2: (iv_ruleText= ruleText EOF )
            // InternalVideoGen.g:782:2: iv_ruleText= ruleText EOF
            {
             newCompositeNode(grammarAccess.getTextRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleText=ruleText();

            state._fsp--;

             current =iv_ruleText; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleText"


    // $ANTLR start "ruleText"
    // InternalVideoGen.g:789:1: ruleText returns [EObject current=null] : (this_LEFT_BRACKET_0= RULE_LEFT_BRACKET otherlv_1= 'content' ( (lv_content_2_0= RULE_STRING ) ) otherlv_3= 'position' ( (lv_position_4_0= rulePosition ) ) otherlv_5= 'color' ( (lv_color_6_0= RULE_STRING ) ) otherlv_7= 'size' ( (lv_size_8_0= RULE_INT ) ) this_RIGHT_BRACKET_9= RULE_RIGHT_BRACKET ) ;
    public final EObject ruleText() throws RecognitionException {
        EObject current = null;

        Token this_LEFT_BRACKET_0=null;
        Token otherlv_1=null;
        Token lv_content_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token lv_color_6_0=null;
        Token otherlv_7=null;
        Token lv_size_8_0=null;
        Token this_RIGHT_BRACKET_9=null;
        AntlrDatatypeRuleToken lv_position_4_0 = null;


         enterRule(); 
            
        try {
            // InternalVideoGen.g:792:28: ( (this_LEFT_BRACKET_0= RULE_LEFT_BRACKET otherlv_1= 'content' ( (lv_content_2_0= RULE_STRING ) ) otherlv_3= 'position' ( (lv_position_4_0= rulePosition ) ) otherlv_5= 'color' ( (lv_color_6_0= RULE_STRING ) ) otherlv_7= 'size' ( (lv_size_8_0= RULE_INT ) ) this_RIGHT_BRACKET_9= RULE_RIGHT_BRACKET ) )
            // InternalVideoGen.g:793:1: (this_LEFT_BRACKET_0= RULE_LEFT_BRACKET otherlv_1= 'content' ( (lv_content_2_0= RULE_STRING ) ) otherlv_3= 'position' ( (lv_position_4_0= rulePosition ) ) otherlv_5= 'color' ( (lv_color_6_0= RULE_STRING ) ) otherlv_7= 'size' ( (lv_size_8_0= RULE_INT ) ) this_RIGHT_BRACKET_9= RULE_RIGHT_BRACKET )
            {
            // InternalVideoGen.g:793:1: (this_LEFT_BRACKET_0= RULE_LEFT_BRACKET otherlv_1= 'content' ( (lv_content_2_0= RULE_STRING ) ) otherlv_3= 'position' ( (lv_position_4_0= rulePosition ) ) otherlv_5= 'color' ( (lv_color_6_0= RULE_STRING ) ) otherlv_7= 'size' ( (lv_size_8_0= RULE_INT ) ) this_RIGHT_BRACKET_9= RULE_RIGHT_BRACKET )
            // InternalVideoGen.g:793:2: this_LEFT_BRACKET_0= RULE_LEFT_BRACKET otherlv_1= 'content' ( (lv_content_2_0= RULE_STRING ) ) otherlv_3= 'position' ( (lv_position_4_0= rulePosition ) ) otherlv_5= 'color' ( (lv_color_6_0= RULE_STRING ) ) otherlv_7= 'size' ( (lv_size_8_0= RULE_INT ) ) this_RIGHT_BRACKET_9= RULE_RIGHT_BRACKET
            {
            this_LEFT_BRACKET_0=(Token)match(input,RULE_LEFT_BRACKET,FOLLOW_29); 
             
                newLeafNode(this_LEFT_BRACKET_0, grammarAccess.getTextAccess().getLEFT_BRACKETTerminalRuleCall_0()); 
                
            otherlv_1=(Token)match(input,30,FOLLOW_7); 

                	newLeafNode(otherlv_1, grammarAccess.getTextAccess().getContentKeyword_1());
                
            // InternalVideoGen.g:801:1: ( (lv_content_2_0= RULE_STRING ) )
            // InternalVideoGen.g:802:1: (lv_content_2_0= RULE_STRING )
            {
            // InternalVideoGen.g:802:1: (lv_content_2_0= RULE_STRING )
            // InternalVideoGen.g:803:3: lv_content_2_0= RULE_STRING
            {
            lv_content_2_0=(Token)match(input,RULE_STRING,FOLLOW_30); 

            			newLeafNode(lv_content_2_0, grammarAccess.getTextAccess().getContentSTRINGTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getTextRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"content",
                    		lv_content_2_0, 
                    		"org.eclipse.xtext.common.Terminals.STRING");
            	    

            }


            }

            otherlv_3=(Token)match(input,31,FOLLOW_31); 

                	newLeafNode(otherlv_3, grammarAccess.getTextAccess().getPositionKeyword_3());
                
            // InternalVideoGen.g:823:1: ( (lv_position_4_0= rulePosition ) )
            // InternalVideoGen.g:824:1: (lv_position_4_0= rulePosition )
            {
            // InternalVideoGen.g:824:1: (lv_position_4_0= rulePosition )
            // InternalVideoGen.g:825:3: lv_position_4_0= rulePosition
            {
             
            	        newCompositeNode(grammarAccess.getTextAccess().getPositionPositionParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_32);
            lv_position_4_0=rulePosition();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTextRule());
            	        }
                   		set(
                   			current, 
                   			"position",
                    		lv_position_4_0, 
                    		"org.xtext.example.mydsl.VideoGen.Position");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_5=(Token)match(input,29,FOLLOW_7); 

                	newLeafNode(otherlv_5, grammarAccess.getTextAccess().getColorKeyword_5());
                
            // InternalVideoGen.g:845:1: ( (lv_color_6_0= RULE_STRING ) )
            // InternalVideoGen.g:846:1: (lv_color_6_0= RULE_STRING )
            {
            // InternalVideoGen.g:846:1: (lv_color_6_0= RULE_STRING )
            // InternalVideoGen.g:847:3: lv_color_6_0= RULE_STRING
            {
            lv_color_6_0=(Token)match(input,RULE_STRING,FOLLOW_33); 

            			newLeafNode(lv_color_6_0, grammarAccess.getTextAccess().getColorSTRINGTerminalRuleCall_6_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getTextRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"color",
                    		lv_color_6_0, 
                    		"org.eclipse.xtext.common.Terminals.STRING");
            	    

            }


            }

            otherlv_7=(Token)match(input,24,FOLLOW_16); 

                	newLeafNode(otherlv_7, grammarAccess.getTextAccess().getSizeKeyword_7());
                
            // InternalVideoGen.g:867:1: ( (lv_size_8_0= RULE_INT ) )
            // InternalVideoGen.g:868:1: (lv_size_8_0= RULE_INT )
            {
            // InternalVideoGen.g:868:1: (lv_size_8_0= RULE_INT )
            // InternalVideoGen.g:869:3: lv_size_8_0= RULE_INT
            {
            lv_size_8_0=(Token)match(input,RULE_INT,FOLLOW_26); 

            			newLeafNode(lv_size_8_0, grammarAccess.getTextAccess().getSizeINTTerminalRuleCall_8_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getTextRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"size",
                    		lv_size_8_0, 
                    		"org.eclipse.xtext.common.Terminals.INT");
            	    

            }


            }

            this_RIGHT_BRACKET_9=(Token)match(input,RULE_RIGHT_BRACKET,FOLLOW_2); 
             
                newLeafNode(this_RIGHT_BRACKET_9, grammarAccess.getTextAccess().getRIGHT_BRACKETTerminalRuleCall_9()); 
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleText"


    // $ANTLR start "entryRulePosition"
    // InternalVideoGen.g:897:1: entryRulePosition returns [String current=null] : iv_rulePosition= rulePosition EOF ;
    public final String entryRulePosition() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePosition = null;


        try {
            // InternalVideoGen.g:898:2: (iv_rulePosition= rulePosition EOF )
            // InternalVideoGen.g:899:2: iv_rulePosition= rulePosition EOF
            {
             newCompositeNode(grammarAccess.getPositionRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePosition=rulePosition();

            state._fsp--;

             current =iv_rulePosition.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePosition"


    // $ANTLR start "rulePosition"
    // InternalVideoGen.g:906:1: rulePosition returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'TOP' | kw= 'BOTTOM' | kw= 'CENTER' ) ;
    public final AntlrDatatypeRuleToken rulePosition() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalVideoGen.g:909:28: ( (kw= 'TOP' | kw= 'BOTTOM' | kw= 'CENTER' ) )
            // InternalVideoGen.g:910:1: (kw= 'TOP' | kw= 'BOTTOM' | kw= 'CENTER' )
            {
            // InternalVideoGen.g:910:1: (kw= 'TOP' | kw= 'BOTTOM' | kw= 'CENTER' )
            int alt21=3;
            switch ( input.LA(1) ) {
            case 32:
                {
                alt21=1;
                }
                break;
            case 33:
                {
                alt21=2;
                }
                break;
            case 34:
                {
                alt21=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // InternalVideoGen.g:911:2: kw= 'TOP'
                    {
                    kw=(Token)match(input,32,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getPositionAccess().getTOPKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalVideoGen.g:918:2: kw= 'BOTTOM'
                    {
                    kw=(Token)match(input,33,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getPositionAccess().getBOTTOMKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // InternalVideoGen.g:925:2: kw= 'CENTER'
                    {
                    kw=(Token)match(input,34,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getPositionAccess().getCENTERKeyword_2()); 
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePosition"


    // $ANTLR start "entryRuleFilter"
    // InternalVideoGen.g:938:1: entryRuleFilter returns [EObject current=null] : iv_ruleFilter= ruleFilter EOF ;
    public final EObject entryRuleFilter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFilter = null;


        try {
            // InternalVideoGen.g:939:2: (iv_ruleFilter= ruleFilter EOF )
            // InternalVideoGen.g:940:2: iv_ruleFilter= ruleFilter EOF
            {
             newCompositeNode(grammarAccess.getFilterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFilter=ruleFilter();

            state._fsp--;

             current =iv_ruleFilter; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFilter"


    // $ANTLR start "ruleFilter"
    // InternalVideoGen.g:947:1: ruleFilter returns [EObject current=null] : (this_FlipFilter_0= ruleFlipFilter | this_NegateFilter_1= ruleNegateFilter | this_BlackWhiteFilter_2= ruleBlackWhiteFilter ) ;
    public final EObject ruleFilter() throws RecognitionException {
        EObject current = null;

        EObject this_FlipFilter_0 = null;

        EObject this_NegateFilter_1 = null;

        EObject this_BlackWhiteFilter_2 = null;


         enterRule(); 
            
        try {
            // InternalVideoGen.g:950:28: ( (this_FlipFilter_0= ruleFlipFilter | this_NegateFilter_1= ruleNegateFilter | this_BlackWhiteFilter_2= ruleBlackWhiteFilter ) )
            // InternalVideoGen.g:951:1: (this_FlipFilter_0= ruleFlipFilter | this_NegateFilter_1= ruleNegateFilter | this_BlackWhiteFilter_2= ruleBlackWhiteFilter )
            {
            // InternalVideoGen.g:951:1: (this_FlipFilter_0= ruleFlipFilter | this_NegateFilter_1= ruleNegateFilter | this_BlackWhiteFilter_2= ruleBlackWhiteFilter )
            int alt22=3;
            switch ( input.LA(1) ) {
            case 37:
                {
                alt22=1;
                }
                break;
            case 36:
                {
                alt22=2;
                }
                break;
            case 35:
                {
                alt22=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // InternalVideoGen.g:952:5: this_FlipFilter_0= ruleFlipFilter
                    {
                     
                            newCompositeNode(grammarAccess.getFilterAccess().getFlipFilterParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_FlipFilter_0=ruleFlipFilter();

                    state._fsp--;

                     
                            current = this_FlipFilter_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalVideoGen.g:962:5: this_NegateFilter_1= ruleNegateFilter
                    {
                     
                            newCompositeNode(grammarAccess.getFilterAccess().getNegateFilterParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_2);
                    this_NegateFilter_1=ruleNegateFilter();

                    state._fsp--;

                     
                            current = this_NegateFilter_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // InternalVideoGen.g:972:5: this_BlackWhiteFilter_2= ruleBlackWhiteFilter
                    {
                     
                            newCompositeNode(grammarAccess.getFilterAccess().getBlackWhiteFilterParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_2);
                    this_BlackWhiteFilter_2=ruleBlackWhiteFilter();

                    state._fsp--;

                     
                            current = this_BlackWhiteFilter_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFilter"


    // $ANTLR start "entryRuleBlackWhiteFilter"
    // InternalVideoGen.g:988:1: entryRuleBlackWhiteFilter returns [EObject current=null] : iv_ruleBlackWhiteFilter= ruleBlackWhiteFilter EOF ;
    public final EObject entryRuleBlackWhiteFilter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBlackWhiteFilter = null;


        try {
            // InternalVideoGen.g:989:2: (iv_ruleBlackWhiteFilter= ruleBlackWhiteFilter EOF )
            // InternalVideoGen.g:990:2: iv_ruleBlackWhiteFilter= ruleBlackWhiteFilter EOF
            {
             newCompositeNode(grammarAccess.getBlackWhiteFilterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBlackWhiteFilter=ruleBlackWhiteFilter();

            state._fsp--;

             current =iv_ruleBlackWhiteFilter; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBlackWhiteFilter"


    // $ANTLR start "ruleBlackWhiteFilter"
    // InternalVideoGen.g:997:1: ruleBlackWhiteFilter returns [EObject current=null] : ( () otherlv_1= 'b&w' ) ;
    public final EObject ruleBlackWhiteFilter() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // InternalVideoGen.g:1000:28: ( ( () otherlv_1= 'b&w' ) )
            // InternalVideoGen.g:1001:1: ( () otherlv_1= 'b&w' )
            {
            // InternalVideoGen.g:1001:1: ( () otherlv_1= 'b&w' )
            // InternalVideoGen.g:1001:2: () otherlv_1= 'b&w'
            {
            // InternalVideoGen.g:1001:2: ()
            // InternalVideoGen.g:1002:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getBlackWhiteFilterAccess().getBlackWhiteFilterAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,35,FOLLOW_2); 

                	newLeafNode(otherlv_1, grammarAccess.getBlackWhiteFilterAccess().getBWKeyword_1());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBlackWhiteFilter"


    // $ANTLR start "entryRuleNegateFilter"
    // InternalVideoGen.g:1019:1: entryRuleNegateFilter returns [EObject current=null] : iv_ruleNegateFilter= ruleNegateFilter EOF ;
    public final EObject entryRuleNegateFilter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNegateFilter = null;


        try {
            // InternalVideoGen.g:1020:2: (iv_ruleNegateFilter= ruleNegateFilter EOF )
            // InternalVideoGen.g:1021:2: iv_ruleNegateFilter= ruleNegateFilter EOF
            {
             newCompositeNode(grammarAccess.getNegateFilterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNegateFilter=ruleNegateFilter();

            state._fsp--;

             current =iv_ruleNegateFilter; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNegateFilter"


    // $ANTLR start "ruleNegateFilter"
    // InternalVideoGen.g:1028:1: ruleNegateFilter returns [EObject current=null] : ( () otherlv_1= 'negate' ) ;
    public final EObject ruleNegateFilter() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // InternalVideoGen.g:1031:28: ( ( () otherlv_1= 'negate' ) )
            // InternalVideoGen.g:1032:1: ( () otherlv_1= 'negate' )
            {
            // InternalVideoGen.g:1032:1: ( () otherlv_1= 'negate' )
            // InternalVideoGen.g:1032:2: () otherlv_1= 'negate'
            {
            // InternalVideoGen.g:1032:2: ()
            // InternalVideoGen.g:1033:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getNegateFilterAccess().getNegateFilterAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,36,FOLLOW_2); 

                	newLeafNode(otherlv_1, grammarAccess.getNegateFilterAccess().getNegateKeyword_1());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNegateFilter"


    // $ANTLR start "entryRuleFlipFilter"
    // InternalVideoGen.g:1050:1: entryRuleFlipFilter returns [EObject current=null] : iv_ruleFlipFilter= ruleFlipFilter EOF ;
    public final EObject entryRuleFlipFilter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFlipFilter = null;


        try {
            // InternalVideoGen.g:1051:2: (iv_ruleFlipFilter= ruleFlipFilter EOF )
            // InternalVideoGen.g:1052:2: iv_ruleFlipFilter= ruleFlipFilter EOF
            {
             newCompositeNode(grammarAccess.getFlipFilterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFlipFilter=ruleFlipFilter();

            state._fsp--;

             current =iv_ruleFlipFilter; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFlipFilter"


    // $ANTLR start "ruleFlipFilter"
    // InternalVideoGen.g:1059:1: ruleFlipFilter returns [EObject current=null] : (otherlv_0= 'flip' ( ( (lv_orientation_1_1= 'h' | lv_orientation_1_2= 'horizontal' | lv_orientation_1_3= 'v' | lv_orientation_1_4= 'vertical' ) ) ) ) ;
    public final EObject ruleFlipFilter() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_orientation_1_1=null;
        Token lv_orientation_1_2=null;
        Token lv_orientation_1_3=null;
        Token lv_orientation_1_4=null;

         enterRule(); 
            
        try {
            // InternalVideoGen.g:1062:28: ( (otherlv_0= 'flip' ( ( (lv_orientation_1_1= 'h' | lv_orientation_1_2= 'horizontal' | lv_orientation_1_3= 'v' | lv_orientation_1_4= 'vertical' ) ) ) ) )
            // InternalVideoGen.g:1063:1: (otherlv_0= 'flip' ( ( (lv_orientation_1_1= 'h' | lv_orientation_1_2= 'horizontal' | lv_orientation_1_3= 'v' | lv_orientation_1_4= 'vertical' ) ) ) )
            {
            // InternalVideoGen.g:1063:1: (otherlv_0= 'flip' ( ( (lv_orientation_1_1= 'h' | lv_orientation_1_2= 'horizontal' | lv_orientation_1_3= 'v' | lv_orientation_1_4= 'vertical' ) ) ) )
            // InternalVideoGen.g:1063:3: otherlv_0= 'flip' ( ( (lv_orientation_1_1= 'h' | lv_orientation_1_2= 'horizontal' | lv_orientation_1_3= 'v' | lv_orientation_1_4= 'vertical' ) ) )
            {
            otherlv_0=(Token)match(input,37,FOLLOW_34); 

                	newLeafNode(otherlv_0, grammarAccess.getFlipFilterAccess().getFlipKeyword_0());
                
            // InternalVideoGen.g:1067:1: ( ( (lv_orientation_1_1= 'h' | lv_orientation_1_2= 'horizontal' | lv_orientation_1_3= 'v' | lv_orientation_1_4= 'vertical' ) ) )
            // InternalVideoGen.g:1068:1: ( (lv_orientation_1_1= 'h' | lv_orientation_1_2= 'horizontal' | lv_orientation_1_3= 'v' | lv_orientation_1_4= 'vertical' ) )
            {
            // InternalVideoGen.g:1068:1: ( (lv_orientation_1_1= 'h' | lv_orientation_1_2= 'horizontal' | lv_orientation_1_3= 'v' | lv_orientation_1_4= 'vertical' ) )
            // InternalVideoGen.g:1069:1: (lv_orientation_1_1= 'h' | lv_orientation_1_2= 'horizontal' | lv_orientation_1_3= 'v' | lv_orientation_1_4= 'vertical' )
            {
            // InternalVideoGen.g:1069:1: (lv_orientation_1_1= 'h' | lv_orientation_1_2= 'horizontal' | lv_orientation_1_3= 'v' | lv_orientation_1_4= 'vertical' )
            int alt23=4;
            switch ( input.LA(1) ) {
            case 38:
                {
                alt23=1;
                }
                break;
            case 39:
                {
                alt23=2;
                }
                break;
            case 40:
                {
                alt23=3;
                }
                break;
            case 41:
                {
                alt23=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // InternalVideoGen.g:1070:3: lv_orientation_1_1= 'h'
                    {
                    lv_orientation_1_1=(Token)match(input,38,FOLLOW_2); 

                            newLeafNode(lv_orientation_1_1, grammarAccess.getFlipFilterAccess().getOrientationHKeyword_1_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getFlipFilterRule());
                    	        }
                           		setWithLastConsumed(current, "orientation", lv_orientation_1_1, null);
                    	    

                    }
                    break;
                case 2 :
                    // InternalVideoGen.g:1082:8: lv_orientation_1_2= 'horizontal'
                    {
                    lv_orientation_1_2=(Token)match(input,39,FOLLOW_2); 

                            newLeafNode(lv_orientation_1_2, grammarAccess.getFlipFilterAccess().getOrientationHorizontalKeyword_1_0_1());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getFlipFilterRule());
                    	        }
                           		setWithLastConsumed(current, "orientation", lv_orientation_1_2, null);
                    	    

                    }
                    break;
                case 3 :
                    // InternalVideoGen.g:1094:8: lv_orientation_1_3= 'v'
                    {
                    lv_orientation_1_3=(Token)match(input,40,FOLLOW_2); 

                            newLeafNode(lv_orientation_1_3, grammarAccess.getFlipFilterAccess().getOrientationVKeyword_1_0_2());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getFlipFilterRule());
                    	        }
                           		setWithLastConsumed(current, "orientation", lv_orientation_1_3, null);
                    	    

                    }
                    break;
                case 4 :
                    // InternalVideoGen.g:1106:8: lv_orientation_1_4= 'vertical'
                    {
                    lv_orientation_1_4=(Token)match(input,41,FOLLOW_2); 

                            newLeafNode(lv_orientation_1_4, grammarAccess.getFlipFilterAccess().getOrientationVerticalKeyword_1_0_3());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getFlipFilterRule());
                    	        }
                           		setWithLastConsumed(current, "orientation", lv_orientation_1_4, null);
                    	    

                    }
                    break;

            }


            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFlipFilter"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x00000000000E0000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x00000000000E0020L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000018002L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000090L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000100020L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x000000001FE00020L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x000000001FC00020L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x000000001F800020L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x000000001F000020L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x000000001E000020L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x000000001C000020L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000018000020L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000010000020L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000003800000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000021000020L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000001000020L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000700000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x000003C000000000L});

}