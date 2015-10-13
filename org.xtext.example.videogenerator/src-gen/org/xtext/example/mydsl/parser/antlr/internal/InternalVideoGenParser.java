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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_LEFT_BRACKET", "RULE_RIGHT_BRACKET", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'VideoGen'", "'@author'", "'@version'", "'@creation'", "'mandatory'", "'optional'", "'alternatives'", "'videoseq'", "'duration'", "'probability'", "'description'"
    };
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=10;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int RULE_RIGHT_BRACKET=5;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_ID=7;
    public static final int RULE_WS=11;
    public static final int RULE_LEFT_BRACKET=4;
    public static final int RULE_ANY_OTHER=12;
    public static final int RULE_INT=8;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__23=23;
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
    public String getGrammarFileName() { return "../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g"; }



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
    // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:67:1: entryRuleVideoGeneratorModel returns [EObject current=null] : iv_ruleVideoGeneratorModel= ruleVideoGeneratorModel EOF ;
    public final EObject entryRuleVideoGeneratorModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVideoGeneratorModel = null;


        try {
            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:68:2: (iv_ruleVideoGeneratorModel= ruleVideoGeneratorModel EOF )
            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:69:2: iv_ruleVideoGeneratorModel= ruleVideoGeneratorModel EOF
            {
             newCompositeNode(grammarAccess.getVideoGeneratorModelRule()); 
            pushFollow(FOLLOW_ruleVideoGeneratorModel_in_entryRuleVideoGeneratorModel75);
            iv_ruleVideoGeneratorModel=ruleVideoGeneratorModel();

            state._fsp--;

             current =iv_ruleVideoGeneratorModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVideoGeneratorModel85); 

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
    // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:76:1: ruleVideoGeneratorModel returns [EObject current=null] : ( () ( (lv_information_1_0= ruleVideoGenInformation ) ) otherlv_2= 'VideoGen' this_LEFT_BRACKET_3= RULE_LEFT_BRACKET ( (lv_videoseqs_4_0= ruleVideoSeq ) )+ this_RIGHT_BRACKET_5= RULE_RIGHT_BRACKET ) ;
    public final EObject ruleVideoGeneratorModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token this_LEFT_BRACKET_3=null;
        Token this_RIGHT_BRACKET_5=null;
        EObject lv_information_1_0 = null;

        EObject lv_videoseqs_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:79:28: ( ( () ( (lv_information_1_0= ruleVideoGenInformation ) ) otherlv_2= 'VideoGen' this_LEFT_BRACKET_3= RULE_LEFT_BRACKET ( (lv_videoseqs_4_0= ruleVideoSeq ) )+ this_RIGHT_BRACKET_5= RULE_RIGHT_BRACKET ) )
            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:80:1: ( () ( (lv_information_1_0= ruleVideoGenInformation ) ) otherlv_2= 'VideoGen' this_LEFT_BRACKET_3= RULE_LEFT_BRACKET ( (lv_videoseqs_4_0= ruleVideoSeq ) )+ this_RIGHT_BRACKET_5= RULE_RIGHT_BRACKET )
            {
            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:80:1: ( () ( (lv_information_1_0= ruleVideoGenInformation ) ) otherlv_2= 'VideoGen' this_LEFT_BRACKET_3= RULE_LEFT_BRACKET ( (lv_videoseqs_4_0= ruleVideoSeq ) )+ this_RIGHT_BRACKET_5= RULE_RIGHT_BRACKET )
            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:80:2: () ( (lv_information_1_0= ruleVideoGenInformation ) ) otherlv_2= 'VideoGen' this_LEFT_BRACKET_3= RULE_LEFT_BRACKET ( (lv_videoseqs_4_0= ruleVideoSeq ) )+ this_RIGHT_BRACKET_5= RULE_RIGHT_BRACKET
            {
            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:80:2: ()
            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:81:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getVideoGeneratorModelAccess().getVideoGeneratorModelAction_0(),
                        current);
                

            }

            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:86:2: ( (lv_information_1_0= ruleVideoGenInformation ) )
            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:87:1: (lv_information_1_0= ruleVideoGenInformation )
            {
            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:87:1: (lv_information_1_0= ruleVideoGenInformation )
            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:88:3: lv_information_1_0= ruleVideoGenInformation
            {
             
            	        newCompositeNode(grammarAccess.getVideoGeneratorModelAccess().getInformationVideoGenInformationParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleVideoGenInformation_in_ruleVideoGeneratorModel140);
            lv_information_1_0=ruleVideoGenInformation();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getVideoGeneratorModelRule());
            	        }
                   		set(
                   			current, 
                   			"information",
                    		lv_information_1_0, 
                    		"VideoGenInformation");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,13,FOLLOW_13_in_ruleVideoGeneratorModel152); 

                	newLeafNode(otherlv_2, grammarAccess.getVideoGeneratorModelAccess().getVideoGenKeyword_2());
                
            this_LEFT_BRACKET_3=(Token)match(input,RULE_LEFT_BRACKET,FOLLOW_RULE_LEFT_BRACKET_in_ruleVideoGeneratorModel163); 
             
                newLeafNode(this_LEFT_BRACKET_3, grammarAccess.getVideoGeneratorModelAccess().getLEFT_BRACKETTerminalRuleCall_3()); 
                
            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:112:1: ( (lv_videoseqs_4_0= ruleVideoSeq ) )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=17 && LA1_0<=19)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:113:1: (lv_videoseqs_4_0= ruleVideoSeq )
            	    {
            	    // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:113:1: (lv_videoseqs_4_0= ruleVideoSeq )
            	    // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:114:3: lv_videoseqs_4_0= ruleVideoSeq
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getVideoGeneratorModelAccess().getVideoseqsVideoSeqParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleVideoSeq_in_ruleVideoGeneratorModel183);
            	    lv_videoseqs_4_0=ruleVideoSeq();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getVideoGeneratorModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"videoseqs",
            	            		lv_videoseqs_4_0, 
            	            		"VideoSeq");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);

            this_RIGHT_BRACKET_5=(Token)match(input,RULE_RIGHT_BRACKET,FOLLOW_RULE_RIGHT_BRACKET_in_ruleVideoGeneratorModel195); 
             
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
    // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:142:1: entryRuleVideoGenInformation returns [EObject current=null] : iv_ruleVideoGenInformation= ruleVideoGenInformation EOF ;
    public final EObject entryRuleVideoGenInformation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVideoGenInformation = null;


        try {
            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:143:2: (iv_ruleVideoGenInformation= ruleVideoGenInformation EOF )
            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:144:2: iv_ruleVideoGenInformation= ruleVideoGenInformation EOF
            {
             newCompositeNode(grammarAccess.getVideoGenInformationRule()); 
            pushFollow(FOLLOW_ruleVideoGenInformation_in_entryRuleVideoGenInformation230);
            iv_ruleVideoGenInformation=ruleVideoGenInformation();

            state._fsp--;

             current =iv_ruleVideoGenInformation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVideoGenInformation240); 

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
    // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:151:1: ruleVideoGenInformation returns [EObject current=null] : ( () (otherlv_1= '@author' ( (lv_authorName_2_0= RULE_STRING ) ) )? (otherlv_3= '@version' ( (lv_version_4_0= RULE_STRING ) ) )? (otherlv_5= '@creation' ( (lv_creationDate_6_0= RULE_STRING ) ) )? ) ;
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
            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:154:28: ( ( () (otherlv_1= '@author' ( (lv_authorName_2_0= RULE_STRING ) ) )? (otherlv_3= '@version' ( (lv_version_4_0= RULE_STRING ) ) )? (otherlv_5= '@creation' ( (lv_creationDate_6_0= RULE_STRING ) ) )? ) )
            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:155:1: ( () (otherlv_1= '@author' ( (lv_authorName_2_0= RULE_STRING ) ) )? (otherlv_3= '@version' ( (lv_version_4_0= RULE_STRING ) ) )? (otherlv_5= '@creation' ( (lv_creationDate_6_0= RULE_STRING ) ) )? )
            {
            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:155:1: ( () (otherlv_1= '@author' ( (lv_authorName_2_0= RULE_STRING ) ) )? (otherlv_3= '@version' ( (lv_version_4_0= RULE_STRING ) ) )? (otherlv_5= '@creation' ( (lv_creationDate_6_0= RULE_STRING ) ) )? )
            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:155:2: () (otherlv_1= '@author' ( (lv_authorName_2_0= RULE_STRING ) ) )? (otherlv_3= '@version' ( (lv_version_4_0= RULE_STRING ) ) )? (otherlv_5= '@creation' ( (lv_creationDate_6_0= RULE_STRING ) ) )?
            {
            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:155:2: ()
            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:156:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getVideoGenInformationAccess().getVideoGenInformationAction_0(),
                        current);
                

            }

            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:161:2: (otherlv_1= '@author' ( (lv_authorName_2_0= RULE_STRING ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==14) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:161:4: otherlv_1= '@author' ( (lv_authorName_2_0= RULE_STRING ) )
                    {
                    otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleVideoGenInformation287); 

                        	newLeafNode(otherlv_1, grammarAccess.getVideoGenInformationAccess().getAuthorKeyword_1_0());
                        
                    // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:165:1: ( (lv_authorName_2_0= RULE_STRING ) )
                    // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:166:1: (lv_authorName_2_0= RULE_STRING )
                    {
                    // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:166:1: (lv_authorName_2_0= RULE_STRING )
                    // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:167:3: lv_authorName_2_0= RULE_STRING
                    {
                    lv_authorName_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleVideoGenInformation304); 

                    			newLeafNode(lv_authorName_2_0, grammarAccess.getVideoGenInformationAccess().getAuthorNameSTRINGTerminalRuleCall_1_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getVideoGenInformationRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"authorName",
                            		lv_authorName_2_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:183:4: (otherlv_3= '@version' ( (lv_version_4_0= RULE_STRING ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==15) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:183:6: otherlv_3= '@version' ( (lv_version_4_0= RULE_STRING ) )
                    {
                    otherlv_3=(Token)match(input,15,FOLLOW_15_in_ruleVideoGenInformation324); 

                        	newLeafNode(otherlv_3, grammarAccess.getVideoGenInformationAccess().getVersionKeyword_2_0());
                        
                    // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:187:1: ( (lv_version_4_0= RULE_STRING ) )
                    // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:188:1: (lv_version_4_0= RULE_STRING )
                    {
                    // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:188:1: (lv_version_4_0= RULE_STRING )
                    // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:189:3: lv_version_4_0= RULE_STRING
                    {
                    lv_version_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleVideoGenInformation341); 

                    			newLeafNode(lv_version_4_0, grammarAccess.getVideoGenInformationAccess().getVersionSTRINGTerminalRuleCall_2_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getVideoGenInformationRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"version",
                            		lv_version_4_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:205:4: (otherlv_5= '@creation' ( (lv_creationDate_6_0= RULE_STRING ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==16) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:205:6: otherlv_5= '@creation' ( (lv_creationDate_6_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,16,FOLLOW_16_in_ruleVideoGenInformation361); 

                        	newLeafNode(otherlv_5, grammarAccess.getVideoGenInformationAccess().getCreationKeyword_3_0());
                        
                    // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:209:1: ( (lv_creationDate_6_0= RULE_STRING ) )
                    // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:210:1: (lv_creationDate_6_0= RULE_STRING )
                    {
                    // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:210:1: (lv_creationDate_6_0= RULE_STRING )
                    // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:211:3: lv_creationDate_6_0= RULE_STRING
                    {
                    lv_creationDate_6_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleVideoGenInformation378); 

                    			newLeafNode(lv_creationDate_6_0, grammarAccess.getVideoGenInformationAccess().getCreationDateSTRINGTerminalRuleCall_3_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getVideoGenInformationRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"creationDate",
                            		lv_creationDate_6_0, 
                            		"STRING");
                    	    

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
    // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:235:1: entryRuleVideoSeq returns [EObject current=null] : iv_ruleVideoSeq= ruleVideoSeq EOF ;
    public final EObject entryRuleVideoSeq() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVideoSeq = null;


        try {
            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:236:2: (iv_ruleVideoSeq= ruleVideoSeq EOF )
            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:237:2: iv_ruleVideoSeq= ruleVideoSeq EOF
            {
             newCompositeNode(grammarAccess.getVideoSeqRule()); 
            pushFollow(FOLLOW_ruleVideoSeq_in_entryRuleVideoSeq421);
            iv_ruleVideoSeq=ruleVideoSeq();

            state._fsp--;

             current =iv_ruleVideoSeq; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVideoSeq431); 

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
    // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:244:1: ruleVideoSeq returns [EObject current=null] : (this_MandatoryVideoSeq_0= ruleMandatoryVideoSeq | this_OptionalVideoSeq_1= ruleOptionalVideoSeq | this_AlternativeVideoSeq_2= ruleAlternativeVideoSeq ) ;
    public final EObject ruleVideoSeq() throws RecognitionException {
        EObject current = null;

        EObject this_MandatoryVideoSeq_0 = null;

        EObject this_OptionalVideoSeq_1 = null;

        EObject this_AlternativeVideoSeq_2 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:247:28: ( (this_MandatoryVideoSeq_0= ruleMandatoryVideoSeq | this_OptionalVideoSeq_1= ruleOptionalVideoSeq | this_AlternativeVideoSeq_2= ruleAlternativeVideoSeq ) )
            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:248:1: (this_MandatoryVideoSeq_0= ruleMandatoryVideoSeq | this_OptionalVideoSeq_1= ruleOptionalVideoSeq | this_AlternativeVideoSeq_2= ruleAlternativeVideoSeq )
            {
            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:248:1: (this_MandatoryVideoSeq_0= ruleMandatoryVideoSeq | this_OptionalVideoSeq_1= ruleOptionalVideoSeq | this_AlternativeVideoSeq_2= ruleAlternativeVideoSeq )
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
                    // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:249:5: this_MandatoryVideoSeq_0= ruleMandatoryVideoSeq
                    {
                     
                            newCompositeNode(grammarAccess.getVideoSeqAccess().getMandatoryVideoSeqParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleMandatoryVideoSeq_in_ruleVideoSeq478);
                    this_MandatoryVideoSeq_0=ruleMandatoryVideoSeq();

                    state._fsp--;

                     
                            current = this_MandatoryVideoSeq_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:259:5: this_OptionalVideoSeq_1= ruleOptionalVideoSeq
                    {
                     
                            newCompositeNode(grammarAccess.getVideoSeqAccess().getOptionalVideoSeqParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleOptionalVideoSeq_in_ruleVideoSeq505);
                    this_OptionalVideoSeq_1=ruleOptionalVideoSeq();

                    state._fsp--;

                     
                            current = this_OptionalVideoSeq_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:269:5: this_AlternativeVideoSeq_2= ruleAlternativeVideoSeq
                    {
                     
                            newCompositeNode(grammarAccess.getVideoSeqAccess().getAlternativeVideoSeqParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleAlternativeVideoSeq_in_ruleVideoSeq532);
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
    // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:285:1: entryRuleMandatoryVideoSeq returns [EObject current=null] : iv_ruleMandatoryVideoSeq= ruleMandatoryVideoSeq EOF ;
    public final EObject entryRuleMandatoryVideoSeq() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMandatoryVideoSeq = null;


        try {
            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:286:2: (iv_ruleMandatoryVideoSeq= ruleMandatoryVideoSeq EOF )
            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:287:2: iv_ruleMandatoryVideoSeq= ruleMandatoryVideoSeq EOF
            {
             newCompositeNode(grammarAccess.getMandatoryVideoSeqRule()); 
            pushFollow(FOLLOW_ruleMandatoryVideoSeq_in_entryRuleMandatoryVideoSeq567);
            iv_ruleMandatoryVideoSeq=ruleMandatoryVideoSeq();

            state._fsp--;

             current =iv_ruleMandatoryVideoSeq; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMandatoryVideoSeq577); 

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
    // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:294:1: ruleMandatoryVideoSeq returns [EObject current=null] : (otherlv_0= 'mandatory' ( (lv_description_1_0= ruleVideoDescription ) ) ) ;
    public final EObject ruleMandatoryVideoSeq() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_description_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:297:28: ( (otherlv_0= 'mandatory' ( (lv_description_1_0= ruleVideoDescription ) ) ) )
            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:298:1: (otherlv_0= 'mandatory' ( (lv_description_1_0= ruleVideoDescription ) ) )
            {
            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:298:1: (otherlv_0= 'mandatory' ( (lv_description_1_0= ruleVideoDescription ) ) )
            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:298:3: otherlv_0= 'mandatory' ( (lv_description_1_0= ruleVideoDescription ) )
            {
            otherlv_0=(Token)match(input,17,FOLLOW_17_in_ruleMandatoryVideoSeq614); 

                	newLeafNode(otherlv_0, grammarAccess.getMandatoryVideoSeqAccess().getMandatoryKeyword_0());
                
            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:302:1: ( (lv_description_1_0= ruleVideoDescription ) )
            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:303:1: (lv_description_1_0= ruleVideoDescription )
            {
            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:303:1: (lv_description_1_0= ruleVideoDescription )
            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:304:3: lv_description_1_0= ruleVideoDescription
            {
             
            	        newCompositeNode(grammarAccess.getMandatoryVideoSeqAccess().getDescriptionVideoDescriptionParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleVideoDescription_in_ruleMandatoryVideoSeq635);
            lv_description_1_0=ruleVideoDescription();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getMandatoryVideoSeqRule());
            	        }
                   		set(
                   			current, 
                   			"description",
                    		lv_description_1_0, 
                    		"VideoDescription");
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
    // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:328:1: entryRuleOptionalVideoSeq returns [EObject current=null] : iv_ruleOptionalVideoSeq= ruleOptionalVideoSeq EOF ;
    public final EObject entryRuleOptionalVideoSeq() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptionalVideoSeq = null;


        try {
            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:329:2: (iv_ruleOptionalVideoSeq= ruleOptionalVideoSeq EOF )
            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:330:2: iv_ruleOptionalVideoSeq= ruleOptionalVideoSeq EOF
            {
             newCompositeNode(grammarAccess.getOptionalVideoSeqRule()); 
            pushFollow(FOLLOW_ruleOptionalVideoSeq_in_entryRuleOptionalVideoSeq671);
            iv_ruleOptionalVideoSeq=ruleOptionalVideoSeq();

            state._fsp--;

             current =iv_ruleOptionalVideoSeq; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOptionalVideoSeq681); 

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
    // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:337:1: ruleOptionalVideoSeq returns [EObject current=null] : (otherlv_0= 'optional' ( (lv_description_1_0= ruleVideoDescription ) ) ) ;
    public final EObject ruleOptionalVideoSeq() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_description_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:340:28: ( (otherlv_0= 'optional' ( (lv_description_1_0= ruleVideoDescription ) ) ) )
            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:341:1: (otherlv_0= 'optional' ( (lv_description_1_0= ruleVideoDescription ) ) )
            {
            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:341:1: (otherlv_0= 'optional' ( (lv_description_1_0= ruleVideoDescription ) ) )
            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:341:3: otherlv_0= 'optional' ( (lv_description_1_0= ruleVideoDescription ) )
            {
            otherlv_0=(Token)match(input,18,FOLLOW_18_in_ruleOptionalVideoSeq718); 

                	newLeafNode(otherlv_0, grammarAccess.getOptionalVideoSeqAccess().getOptionalKeyword_0());
                
            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:345:1: ( (lv_description_1_0= ruleVideoDescription ) )
            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:346:1: (lv_description_1_0= ruleVideoDescription )
            {
            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:346:1: (lv_description_1_0= ruleVideoDescription )
            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:347:3: lv_description_1_0= ruleVideoDescription
            {
             
            	        newCompositeNode(grammarAccess.getOptionalVideoSeqAccess().getDescriptionVideoDescriptionParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleVideoDescription_in_ruleOptionalVideoSeq739);
            lv_description_1_0=ruleVideoDescription();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getOptionalVideoSeqRule());
            	        }
                   		set(
                   			current, 
                   			"description",
                    		lv_description_1_0, 
                    		"VideoDescription");
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
    // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:371:1: entryRuleAlternativeVideoSeq returns [EObject current=null] : iv_ruleAlternativeVideoSeq= ruleAlternativeVideoSeq EOF ;
    public final EObject entryRuleAlternativeVideoSeq() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlternativeVideoSeq = null;


        try {
            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:372:2: (iv_ruleAlternativeVideoSeq= ruleAlternativeVideoSeq EOF )
            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:373:2: iv_ruleAlternativeVideoSeq= ruleAlternativeVideoSeq EOF
            {
             newCompositeNode(grammarAccess.getAlternativeVideoSeqRule()); 
            pushFollow(FOLLOW_ruleAlternativeVideoSeq_in_entryRuleAlternativeVideoSeq775);
            iv_ruleAlternativeVideoSeq=ruleAlternativeVideoSeq();

            state._fsp--;

             current =iv_ruleAlternativeVideoSeq; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAlternativeVideoSeq785); 

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
    // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:380:1: ruleAlternativeVideoSeq returns [EObject current=null] : (otherlv_0= 'alternatives' ( (lv_videoid_1_0= RULE_ID ) )? this_LEFT_BRACKET_2= RULE_LEFT_BRACKET ( (lv_videodescs_3_0= ruleVideoDescription ) )+ this_RIGHT_BRACKET_4= RULE_RIGHT_BRACKET ) ;
    public final EObject ruleAlternativeVideoSeq() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_videoid_1_0=null;
        Token this_LEFT_BRACKET_2=null;
        Token this_RIGHT_BRACKET_4=null;
        EObject lv_videodescs_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:383:28: ( (otherlv_0= 'alternatives' ( (lv_videoid_1_0= RULE_ID ) )? this_LEFT_BRACKET_2= RULE_LEFT_BRACKET ( (lv_videodescs_3_0= ruleVideoDescription ) )+ this_RIGHT_BRACKET_4= RULE_RIGHT_BRACKET ) )
            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:384:1: (otherlv_0= 'alternatives' ( (lv_videoid_1_0= RULE_ID ) )? this_LEFT_BRACKET_2= RULE_LEFT_BRACKET ( (lv_videodescs_3_0= ruleVideoDescription ) )+ this_RIGHT_BRACKET_4= RULE_RIGHT_BRACKET )
            {
            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:384:1: (otherlv_0= 'alternatives' ( (lv_videoid_1_0= RULE_ID ) )? this_LEFT_BRACKET_2= RULE_LEFT_BRACKET ( (lv_videodescs_3_0= ruleVideoDescription ) )+ this_RIGHT_BRACKET_4= RULE_RIGHT_BRACKET )
            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:384:3: otherlv_0= 'alternatives' ( (lv_videoid_1_0= RULE_ID ) )? this_LEFT_BRACKET_2= RULE_LEFT_BRACKET ( (lv_videodescs_3_0= ruleVideoDescription ) )+ this_RIGHT_BRACKET_4= RULE_RIGHT_BRACKET
            {
            otherlv_0=(Token)match(input,19,FOLLOW_19_in_ruleAlternativeVideoSeq822); 

                	newLeafNode(otherlv_0, grammarAccess.getAlternativeVideoSeqAccess().getAlternativesKeyword_0());
                
            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:388:1: ( (lv_videoid_1_0= RULE_ID ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:389:1: (lv_videoid_1_0= RULE_ID )
                    {
                    // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:389:1: (lv_videoid_1_0= RULE_ID )
                    // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:390:3: lv_videoid_1_0= RULE_ID
                    {
                    lv_videoid_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAlternativeVideoSeq839); 

                    			newLeafNode(lv_videoid_1_0, grammarAccess.getAlternativeVideoSeqAccess().getVideoidIDTerminalRuleCall_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAlternativeVideoSeqRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"videoid",
                            		lv_videoid_1_0, 
                            		"ID");
                    	    

                    }


                    }
                    break;

            }

            this_LEFT_BRACKET_2=(Token)match(input,RULE_LEFT_BRACKET,FOLLOW_RULE_LEFT_BRACKET_in_ruleAlternativeVideoSeq856); 
             
                newLeafNode(this_LEFT_BRACKET_2, grammarAccess.getAlternativeVideoSeqAccess().getLEFT_BRACKETTerminalRuleCall_2()); 
                
            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:410:1: ( (lv_videodescs_3_0= ruleVideoDescription ) )+
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
            	    // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:411:1: (lv_videodescs_3_0= ruleVideoDescription )
            	    {
            	    // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:411:1: (lv_videodescs_3_0= ruleVideoDescription )
            	    // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:412:3: lv_videodescs_3_0= ruleVideoDescription
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAlternativeVideoSeqAccess().getVideodescsVideoDescriptionParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleVideoDescription_in_ruleAlternativeVideoSeq876);
            	    lv_videodescs_3_0=ruleVideoDescription();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getAlternativeVideoSeqRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"videodescs",
            	            		lv_videodescs_3_0, 
            	            		"VideoDescription");
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

            this_RIGHT_BRACKET_4=(Token)match(input,RULE_RIGHT_BRACKET,FOLLOW_RULE_RIGHT_BRACKET_in_ruleAlternativeVideoSeq888); 
             
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
    // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:440:1: entryRuleVideoDescription returns [EObject current=null] : iv_ruleVideoDescription= ruleVideoDescription EOF ;
    public final EObject entryRuleVideoDescription() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVideoDescription = null;


        try {
            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:441:2: (iv_ruleVideoDescription= ruleVideoDescription EOF )
            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:442:2: iv_ruleVideoDescription= ruleVideoDescription EOF
            {
             newCompositeNode(grammarAccess.getVideoDescriptionRule()); 
            pushFollow(FOLLOW_ruleVideoDescription_in_entryRuleVideoDescription923);
            iv_ruleVideoDescription=ruleVideoDescription();

            state._fsp--;

             current =iv_ruleVideoDescription; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVideoDescription933); 

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
    // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:449:1: ruleVideoDescription returns [EObject current=null] : (otherlv_0= 'videoseq' ( (lv_videoid_1_0= RULE_ID ) )? ( (lv_location_2_0= RULE_STRING ) ) (this_LEFT_BRACKET_3= RULE_LEFT_BRACKET (otherlv_4= 'duration' ( (lv_duration_5_0= RULE_INT ) ) )? (otherlv_6= 'probability' ( (lv_probability_7_0= RULE_INT ) ) )? (otherlv_8= 'description' ( (lv_description_9_0= RULE_STRING ) ) )? this_RIGHT_BRACKET_10= RULE_RIGHT_BRACKET )? ) ;
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
        Token lv_description_9_0=null;
        Token this_RIGHT_BRACKET_10=null;

         enterRule(); 
            
        try {
            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:452:28: ( (otherlv_0= 'videoseq' ( (lv_videoid_1_0= RULE_ID ) )? ( (lv_location_2_0= RULE_STRING ) ) (this_LEFT_BRACKET_3= RULE_LEFT_BRACKET (otherlv_4= 'duration' ( (lv_duration_5_0= RULE_INT ) ) )? (otherlv_6= 'probability' ( (lv_probability_7_0= RULE_INT ) ) )? (otherlv_8= 'description' ( (lv_description_9_0= RULE_STRING ) ) )? this_RIGHT_BRACKET_10= RULE_RIGHT_BRACKET )? ) )
            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:453:1: (otherlv_0= 'videoseq' ( (lv_videoid_1_0= RULE_ID ) )? ( (lv_location_2_0= RULE_STRING ) ) (this_LEFT_BRACKET_3= RULE_LEFT_BRACKET (otherlv_4= 'duration' ( (lv_duration_5_0= RULE_INT ) ) )? (otherlv_6= 'probability' ( (lv_probability_7_0= RULE_INT ) ) )? (otherlv_8= 'description' ( (lv_description_9_0= RULE_STRING ) ) )? this_RIGHT_BRACKET_10= RULE_RIGHT_BRACKET )? )
            {
            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:453:1: (otherlv_0= 'videoseq' ( (lv_videoid_1_0= RULE_ID ) )? ( (lv_location_2_0= RULE_STRING ) ) (this_LEFT_BRACKET_3= RULE_LEFT_BRACKET (otherlv_4= 'duration' ( (lv_duration_5_0= RULE_INT ) ) )? (otherlv_6= 'probability' ( (lv_probability_7_0= RULE_INT ) ) )? (otherlv_8= 'description' ( (lv_description_9_0= RULE_STRING ) ) )? this_RIGHT_BRACKET_10= RULE_RIGHT_BRACKET )? )
            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:453:3: otherlv_0= 'videoseq' ( (lv_videoid_1_0= RULE_ID ) )? ( (lv_location_2_0= RULE_STRING ) ) (this_LEFT_BRACKET_3= RULE_LEFT_BRACKET (otherlv_4= 'duration' ( (lv_duration_5_0= RULE_INT ) ) )? (otherlv_6= 'probability' ( (lv_probability_7_0= RULE_INT ) ) )? (otherlv_8= 'description' ( (lv_description_9_0= RULE_STRING ) ) )? this_RIGHT_BRACKET_10= RULE_RIGHT_BRACKET )?
            {
            otherlv_0=(Token)match(input,20,FOLLOW_20_in_ruleVideoDescription970); 

                	newLeafNode(otherlv_0, grammarAccess.getVideoDescriptionAccess().getVideoseqKeyword_0());
                
            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:457:1: ( (lv_videoid_1_0= RULE_ID ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:458:1: (lv_videoid_1_0= RULE_ID )
                    {
                    // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:458:1: (lv_videoid_1_0= RULE_ID )
                    // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:459:3: lv_videoid_1_0= RULE_ID
                    {
                    lv_videoid_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVideoDescription987); 

                    			newLeafNode(lv_videoid_1_0, grammarAccess.getVideoDescriptionAccess().getVideoidIDTerminalRuleCall_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getVideoDescriptionRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"videoid",
                            		lv_videoid_1_0, 
                            		"ID");
                    	    

                    }


                    }
                    break;

            }

            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:475:3: ( (lv_location_2_0= RULE_STRING ) )
            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:476:1: (lv_location_2_0= RULE_STRING )
            {
            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:476:1: (lv_location_2_0= RULE_STRING )
            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:477:3: lv_location_2_0= RULE_STRING
            {
            lv_location_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleVideoDescription1010); 

            			newLeafNode(lv_location_2_0, grammarAccess.getVideoDescriptionAccess().getLocationSTRINGTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getVideoDescriptionRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"location",
                    		lv_location_2_0, 
                    		"STRING");
            	    

            }


            }

            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:493:2: (this_LEFT_BRACKET_3= RULE_LEFT_BRACKET (otherlv_4= 'duration' ( (lv_duration_5_0= RULE_INT ) ) )? (otherlv_6= 'probability' ( (lv_probability_7_0= RULE_INT ) ) )? (otherlv_8= 'description' ( (lv_description_9_0= RULE_STRING ) ) )? this_RIGHT_BRACKET_10= RULE_RIGHT_BRACKET )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_LEFT_BRACKET) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:493:3: this_LEFT_BRACKET_3= RULE_LEFT_BRACKET (otherlv_4= 'duration' ( (lv_duration_5_0= RULE_INT ) ) )? (otherlv_6= 'probability' ( (lv_probability_7_0= RULE_INT ) ) )? (otherlv_8= 'description' ( (lv_description_9_0= RULE_STRING ) ) )? this_RIGHT_BRACKET_10= RULE_RIGHT_BRACKET
                    {
                    this_LEFT_BRACKET_3=(Token)match(input,RULE_LEFT_BRACKET,FOLLOW_RULE_LEFT_BRACKET_in_ruleVideoDescription1027); 
                     
                        newLeafNode(this_LEFT_BRACKET_3, grammarAccess.getVideoDescriptionAccess().getLEFT_BRACKETTerminalRuleCall_3_0()); 
                        
                    // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:497:1: (otherlv_4= 'duration' ( (lv_duration_5_0= RULE_INT ) ) )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==21) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:497:3: otherlv_4= 'duration' ( (lv_duration_5_0= RULE_INT ) )
                            {
                            otherlv_4=(Token)match(input,21,FOLLOW_21_in_ruleVideoDescription1039); 

                                	newLeafNode(otherlv_4, grammarAccess.getVideoDescriptionAccess().getDurationKeyword_3_1_0());
                                
                            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:501:1: ( (lv_duration_5_0= RULE_INT ) )
                            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:502:1: (lv_duration_5_0= RULE_INT )
                            {
                            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:502:1: (lv_duration_5_0= RULE_INT )
                            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:503:3: lv_duration_5_0= RULE_INT
                            {
                            lv_duration_5_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleVideoDescription1056); 

                            			newLeafNode(lv_duration_5_0, grammarAccess.getVideoDescriptionAccess().getDurationINTTerminalRuleCall_3_1_1_0()); 
                            		

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getVideoDescriptionRule());
                            	        }
                                   		setWithLastConsumed(
                                   			current, 
                                   			"duration",
                                    		lv_duration_5_0, 
                                    		"INT");
                            	    

                            }


                            }


                            }
                            break;

                    }

                    // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:519:4: (otherlv_6= 'probability' ( (lv_probability_7_0= RULE_INT ) ) )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==22) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:519:6: otherlv_6= 'probability' ( (lv_probability_7_0= RULE_INT ) )
                            {
                            otherlv_6=(Token)match(input,22,FOLLOW_22_in_ruleVideoDescription1076); 

                                	newLeafNode(otherlv_6, grammarAccess.getVideoDescriptionAccess().getProbabilityKeyword_3_2_0());
                                
                            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:523:1: ( (lv_probability_7_0= RULE_INT ) )
                            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:524:1: (lv_probability_7_0= RULE_INT )
                            {
                            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:524:1: (lv_probability_7_0= RULE_INT )
                            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:525:3: lv_probability_7_0= RULE_INT
                            {
                            lv_probability_7_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleVideoDescription1093); 

                            			newLeafNode(lv_probability_7_0, grammarAccess.getVideoDescriptionAccess().getProbabilityINTTerminalRuleCall_3_2_1_0()); 
                            		

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getVideoDescriptionRule());
                            	        }
                                   		setWithLastConsumed(
                                   			current, 
                                   			"probability",
                                    		lv_probability_7_0, 
                                    		"INT");
                            	    

                            }


                            }


                            }
                            break;

                    }

                    // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:541:4: (otherlv_8= 'description' ( (lv_description_9_0= RULE_STRING ) ) )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==23) ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:541:6: otherlv_8= 'description' ( (lv_description_9_0= RULE_STRING ) )
                            {
                            otherlv_8=(Token)match(input,23,FOLLOW_23_in_ruleVideoDescription1113); 

                                	newLeafNode(otherlv_8, grammarAccess.getVideoDescriptionAccess().getDescriptionKeyword_3_3_0());
                                
                            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:545:1: ( (lv_description_9_0= RULE_STRING ) )
                            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:546:1: (lv_description_9_0= RULE_STRING )
                            {
                            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:546:1: (lv_description_9_0= RULE_STRING )
                            // ../org.xtext.example.videogenerator/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalVideoGen.g:547:3: lv_description_9_0= RULE_STRING
                            {
                            lv_description_9_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleVideoDescription1130); 

                            			newLeafNode(lv_description_9_0, grammarAccess.getVideoDescriptionAccess().getDescriptionSTRINGTerminalRuleCall_3_3_1_0()); 
                            		

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getVideoDescriptionRule());
                            	        }
                                   		setWithLastConsumed(
                                   			current, 
                                   			"description",
                                    		lv_description_9_0, 
                                    		"STRING");
                            	    

                            }


                            }


                            }
                            break;

                    }

                    this_RIGHT_BRACKET_10=(Token)match(input,RULE_RIGHT_BRACKET,FOLLOW_RULE_RIGHT_BRACKET_in_ruleVideoDescription1148); 
                     
                        newLeafNode(this_RIGHT_BRACKET_10, grammarAccess.getVideoDescriptionAccess().getRIGHT_BRACKETTerminalRuleCall_3_4()); 
                        

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

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleVideoGeneratorModel_in_entryRuleVideoGeneratorModel75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVideoGeneratorModel85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVideoGenInformation_in_ruleVideoGeneratorModel140 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleVideoGeneratorModel152 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_LEFT_BRACKET_in_ruleVideoGeneratorModel163 = new BitSet(new long[]{0x00000000000E0000L});
    public static final BitSet FOLLOW_ruleVideoSeq_in_ruleVideoGeneratorModel183 = new BitSet(new long[]{0x00000000000E0020L});
    public static final BitSet FOLLOW_RULE_RIGHT_BRACKET_in_ruleVideoGeneratorModel195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVideoGenInformation_in_entryRuleVideoGenInformation230 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVideoGenInformation240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleVideoGenInformation287 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleVideoGenInformation304 = new BitSet(new long[]{0x0000000000018002L});
    public static final BitSet FOLLOW_15_in_ruleVideoGenInformation324 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleVideoGenInformation341 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleVideoGenInformation361 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleVideoGenInformation378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVideoSeq_in_entryRuleVideoSeq421 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVideoSeq431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMandatoryVideoSeq_in_ruleVideoSeq478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOptionalVideoSeq_in_ruleVideoSeq505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAlternativeVideoSeq_in_ruleVideoSeq532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMandatoryVideoSeq_in_entryRuleMandatoryVideoSeq567 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMandatoryVideoSeq577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleMandatoryVideoSeq614 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_ruleVideoDescription_in_ruleMandatoryVideoSeq635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOptionalVideoSeq_in_entryRuleOptionalVideoSeq671 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOptionalVideoSeq681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleOptionalVideoSeq718 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_ruleVideoDescription_in_ruleOptionalVideoSeq739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAlternativeVideoSeq_in_entryRuleAlternativeVideoSeq775 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAlternativeVideoSeq785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleAlternativeVideoSeq822 = new BitSet(new long[]{0x0000000000000090L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAlternativeVideoSeq839 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_LEFT_BRACKET_in_ruleAlternativeVideoSeq856 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_ruleVideoDescription_in_ruleAlternativeVideoSeq876 = new BitSet(new long[]{0x0000000000100020L});
    public static final BitSet FOLLOW_RULE_RIGHT_BRACKET_in_ruleAlternativeVideoSeq888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVideoDescription_in_entryRuleVideoDescription923 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVideoDescription933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleVideoDescription970 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVideoDescription987 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleVideoDescription1010 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_RULE_LEFT_BRACKET_in_ruleVideoDescription1027 = new BitSet(new long[]{0x0000000000E00020L});
    public static final BitSet FOLLOW_21_in_ruleVideoDescription1039 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleVideoDescription1056 = new BitSet(new long[]{0x0000000000C00020L});
    public static final BitSet FOLLOW_22_in_ruleVideoDescription1076 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleVideoDescription1093 = new BitSet(new long[]{0x0000000000800020L});
    public static final BitSet FOLLOW_23_in_ruleVideoDescription1113 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleVideoDescription1130 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_RIGHT_BRACKET_in_ruleVideoDescription1148 = new BitSet(new long[]{0x0000000000000002L});

}